package com.pinheiro.michael.assessmentprojetodebloco.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pinheiro.michael.assessmentprojetodebloco.R
import com.pinheiro.michael.assessmentprojetodebloco.databinding.FragmentProfileBinding
import com.pinheiro.michael.assessmentprojetodebloco.service.CardModel
import com.pinheiro.michael.assessmentprojetodebloco.service.findCards
import com.pinheiro.michael.assessmentprojetodebloco.ui.catalog.CardListener
import com.pinheiro.michael.assessmentprojetodebloco.ui.catalog.CatalogAdapter

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CatalogAdapter
    private val viewModel by viewModels<ProfileViewModel>()
    var newDeck = mutableSetOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        adapter = CatalogAdapter(object : CardListener {
            override fun clickVisualizar(card: CardModel, item: View) {
                if(binding.cardDeckEditr.root.isVisible){
                    if (newDeck.size < 7) {
                        newDeck.add(card.id)
                        item.alpha = 0.5f
                    }
                }
            }
        })

        val playerDeck = viewModel.retrieveDeck()

        setupViews()
        atualizaRecyclerView(playerDeck, binding.recyclerDeck)


        return binding.root
    }

    private fun setupViews() {
        binding.recyclerDeck.layoutManager = GridLayoutManager(
            requireContext(),
            2
        )

        binding.fabEdit.setOnClickListener {
            openEditor()
        }

        binding.tvEmail.text = viewModel.retrieveUserInfo().email
    }

    private fun openEditor() {

        with(binding.cardDeckEditr) {
            recyclerDeckEditor.layoutManager = GridLayoutManager(
                requireContext(),
                2
            )
            root.isVisible = true
            tvFinalizar.setOnClickListener {
                finishEdition()
            }
            tvResetar.setOnClickListener {

            }
            btnCancelar.setOnClickListener {
                root.isVisible = false
            }

            atualizaRecyclerView(viewModel.retrieveUserInfo().cardsIds.findCards(), recyclerDeckEditor)

        }


    }

    private fun finishEdition() {
        if (newDeck.size == 7) {
            viewModel.updateDeck(newDeck.toList())
            binding.cardDeckEditr.root.isVisible = false
            atualizaRecyclerView(newDeck.toList().findCards(),binding.recyclerDeck)
        } else {
            Toast.makeText(requireContext(), "Escolha 7 cartas", Toast.LENGTH_SHORT).show()
        }
    }

    fun atualizaRecyclerView(lista: List<CardModel>, recyclerView: RecyclerView) {
        adapter.submitList(lista)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}