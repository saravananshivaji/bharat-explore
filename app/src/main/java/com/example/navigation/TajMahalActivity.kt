package com.example.navigation

import android.app.Activity
import android.app.ActivityManager
import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.Anchor
import com.google.ar.core.HitResult
import com.google.ar.core.Plane
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import java.util.Objects
import java.util.function.Consumer
import java.util.function.Function

class TajMahalActivity : AppCompatActivity() {
    private var clickNo = 0
    private var arCam: ArFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_taj_mahal)

        if (checkSystemSupport(this)) {
            //Connecting to the UI
            // ArFragment is linked up with its respective id used in the activity_main.xml
            arCam = supportFragmentManager.findFragmentById(R.id.arFragment) as ArFragment?

            checkNotNull(arCam)
            arCam!!.setOnTapArPlaneListener { hitResult: HitResult, plane: Plane?, motionEvent: MotionEvent? ->
                clickNo++
                //rendering the model when click is 1
                if (clickNo == 1) {
                    //fixing the coordinates in the detected plane
                    val imageName = intent.getStringExtra("image_name")
                    val anchor = hitResult.createAnchor()
                    ModelRenderable.builder()
                        .setSource(this, (if (imageName == "tiger") { R.raw.tiger } else { R.raw.simpoly_india_gate})) // set glb model
                        .setIsFilamentGltf(true)
                        .build()
                        .thenAccept(Consumer<ModelRenderable> { modelRenderable: ModelRenderable ->
                            addModel(
                                anchor,
                                modelRenderable
                            )
                        })
                        .exceptionally(Function<Throwable, Void?> { throwable: Throwable ->
                            val builder = AlertDialog.Builder(this)
                            builder.setMessage("Something is not right" + throwable.message).show()
                            null
                        })
                }
            }
        }
    }

    //Function to render the model
    private fun addModel(anchor: Anchor, modelRenderable: ModelRenderable) {
        // Creating a AnchorNode with a specific anchor
        val anchorNode = AnchorNode(anchor)

        // attaching the anchorNode with the ArFragment
        anchorNode.parent = arCam!!.arSceneView.scene

        // attaching the anchorNode with the TransformableNode
        val model = TransformableNode(arCam!!.transformationSystem)
        model.parent = anchorNode
        // attaching the 3d model with the TransformableNode
        // that is already attached with the node
        model.setRenderable(modelRenderable)
        model.select()
    }


    companion object {
        //Function to check whether the android device is compatible with ARCORE
        fun checkSystemSupport(activity: Activity): Boolean {
            // checking whether the API version of the running Android >= 24
            // that means Android Nougat 7.0
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val openGlVersion = (Objects.requireNonNull(
                    activity.getSystemService(
                        ACTIVITY_SERVICE
                    )
                ) as ActivityManager).deviceConfigurationInfo.glEsVersion
                // checking whether the OpenGL version >= 3.0
                if (openGlVersion.toDouble() >= 3.0) {
                    return true
                } else {
                    Toast.makeText(
                        activity,
                        "App needs OpenGl Version 3.0 or later",
                        Toast.LENGTH_SHORT
                    ).show()
                    activity.finish()
                    return false
                }
            } else {
                Toast.makeText(
                    activity,
                    "App does not support required Build Version",
                    Toast.LENGTH_SHORT
                ).show()
                activity.finish()
                return false
            }
        }
    }
}