package com.pinheiro.michael.assessmentprojetodebloco.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.pinheiro.michael.assessmentprojetodebloco.R
import com.pinheiro.michael.assessmentprojetodebloco.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.cvDecks.setContent {
            val lista = listOf("Deck 1", "Deck 2", "Deck 3", "Deck 4", "Deck 5")
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                items(lista.size) { index ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp), backgroundColor = colorResource(
                        id = R.color.cian_dark
                    )) {
                        Text(text = lista[index].toString(), modifier = Modifier.padding(32.dp))
                    }
                }
            }


        }
        
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}