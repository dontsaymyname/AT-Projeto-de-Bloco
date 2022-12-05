package com.pinheiro.michael.assessmentprojetodebloco.ui.game

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.fragment.app.Fragment
import com.pinheiro.michael.assessmentprojetodebloco.databinding.FragmentGameBinding
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private lateinit var repository: LoginRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGameBinding.inflate(inflater, container, false)
        repository = LoginRepository.get()

        binding.btnPlay.setOnClickListener {
            startActivity(Intent(activity, InGameActivity::class.java))
        }
        binding.btnHelp.setOnClickListener {
            repository.logout()
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}