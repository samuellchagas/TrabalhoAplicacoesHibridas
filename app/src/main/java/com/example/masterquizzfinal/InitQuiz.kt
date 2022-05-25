package com.example.masterquizzfinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.masterquizzfinal.databinding.FragmentInitQuizBinding
import com.example.masterquizzfinal.databinding.FragmentLoginBinding

class InitQuiz: Fragment() {

    private val binding: FragmentInitQuizBinding by lazy {
        FragmentInitQuizBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView2.setOnClickListener {
            findNavController().navigate(R.id.action_initQuiz_to_subject_fragment)
        }
    }
}