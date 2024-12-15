package com.example.navigation.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navigation.Constants
import com.example.navigation.QuizQuestionsActivity
import com.example.navigation.databinding.FragmentGalleryBinding
import com.example.navigation.databinding.FragmentQuizBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val etName: TextView = binding.etName
        val btnStart: Button = binding.btnStart

        btnStart.setOnClickListener {
            if (etName.text.isEmpty()) {
                Toast.makeText(requireContext(), "Please, enter your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(requireContext(), QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}