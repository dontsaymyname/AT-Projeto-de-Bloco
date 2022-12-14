package com.pinheiro.michael.assessmentprojetodebloco.ui.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.pinheiro.michael.assessmentprojetodebloco.databinding.FragmentCatalogBinding
import com.pinheiro.michael.assessmentprojetodebloco.service.CardModel
import com.pinheiro.michael.assessmentprojetodebloco.service.AllCards

class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CatalogAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        adapter = CatalogAdapter(object : CardListener {
            override fun clickVisualizar(card: CardModel, view: View) {
                Toast.makeText(
                    requireContext(),
                    "Click do item OK ${card.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        setupViews()
        atualizaRecyclerView(AllCards.cardsList)

        return binding.root
    }

    private fun setupViews() {
        binding.recyclerCards.layoutManager = GridLayoutManager(
            requireContext(),
            2
        )
    }

    fun atualizaRecyclerView(lista: List<CardModel>) {
        adapter.submitList(lista)
        binding.recyclerCards.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

//binding.composeView.setContent {
//            val lista = listOf("https://cdn.midjourney.com/2049dd0e-ffe0-4602-8e07-2561868e35aa/grid_0.png",
//                "https://cdn.midjourney.com/17e03cd6-b041-4899-9d3b-4fb03c8cd5c6/grid_0.png",
//                "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
//                "https://cdn.midjourney.com/0ba3a3f9-2d9d-4f8d-bdf3-a3dca588bd00/grid_0.png",
//                "https://cdn.midjourney.com/ad09c879-34bc-4889-9aa4-e3e426ccbfb6/grid_0.png")
//
//            LazyVerticalGrid(
//                columns = GridCells.Adaptive(minSize = 130.dp)
//            ) {
//                items(lista.size) { index ->
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(lista[index])
//                            .crossfade(true)
//                            .memoryCachePolicy(CachePolicy.ENABLED)
//                            .build(),
//                        contentDescription = "",
//                    )
//                }
//            }}