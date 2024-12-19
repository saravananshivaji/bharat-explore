package com.example.bharatexplore.ui.ar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bharatexplore.ARActivity
import com.example.bharatexplore.databinding.FragmentArBinding

class ARFragment : Fragment() {

    private var _binding: FragmentArBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(ARViewModel::class.java)
        _binding = FragmentArBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val btnStart: ImageButton = binding.tajmahalButton
        btnStart.setOnClickListener {
              val intent = Intent(requireContext(), ARActivity::class.java)
            intent.putExtra("image_name", "indiagate")
              startActivity(intent)
        }


        val btnTiger: ImageButton = binding.tigerButton
        btnTiger.setOnClickListener {
            val intent = Intent(requireContext(), ARActivity::class.java)
            intent.putExtra("image_name", "tiger")
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}