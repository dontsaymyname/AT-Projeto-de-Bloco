package com.pinheiro.michael.assessmentprojetodebloco.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.fragment.app.Fragment
import com.pinheiro.michael.assessmentprojetodebloco.databinding.FragmentGameBinding

class GameFragment : Fragment() {
// teste
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGameBinding.inflate(inflater, container, false)

        binding.gamesComposeView.setContent {
            Text(text = "Text do Game Fragment")
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}