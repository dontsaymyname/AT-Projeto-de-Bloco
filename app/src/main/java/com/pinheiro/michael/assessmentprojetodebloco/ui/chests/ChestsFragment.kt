package com.pinheiro.michael.assessmentprojetodebloco.ui.chests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.CircleCropTransformation
import com.pinheiro.michael.assessmentprojetodebloco.databinding.FragmentChestsBinding

class ChestsFragment : Fragment() {

    private var _binding: FragmentChestsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChestsBinding.inflate(inflater, container, false)

        binding.imageView.load("https://cdn.midjourney.com/17e03cd6-b041-4899-9d3b-4fb03c8cd5c6/grid_0.png"){
            transformations(CircleCropTransformation())
        }
        binding.imageView2.load("https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png"){
        }
        binding.imageView3.load("https://cdn.midjourney.com/ad09c879-34bc-4889-9aa4-e3e426ccbfb6/grid_0.png"){
            transformations(CircleCropTransformation())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}