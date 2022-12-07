package com.pinheiro.michael.assessmentprojetodebloco.ui.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pinheiro.michael.assessmentprojetodebloco.R
import com.pinheiro.michael.assessmentprojetodebloco.databinding.ItemCardBinding
import com.pinheiro.michael.assessmentprojetodebloco.service.CardModel
import com.pinheiro.michael.assessmentprojetodebloco.service.Rarity

interface CardListener {
    fun clickVisualizar(card: CardModel, itemView: View)
}

class CatalogAdapter(val cardListener: CardListener) :
    ListAdapter<
            CardModel,
            CatalogAdapter.ViewHolder
            >(CardDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent, cardListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    class ViewHolder private constructor(
        val binding: ItemCardBinding,
        val listener: CardListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CardModel, position: Int) {
            binding.apply {
                tvName.text = item.name
                tvAttack.text = item.atk.toString()
                tvDef.text = item.def.toString()
                tvMagic.text = item.magic.toString()
                imgSprite.load(item.sprite) {
                    placeholder(R.drawable.ic_person)
                }

                containerCard.setBackgroundResource(
                    when (item.rarity) {
                        Rarity.NORMAL -> R.drawable.card_normal
                        Rarity.RARE -> R.drawable.card_rare
                        Rarity.LEGENDARY -> R.drawable.card_legendary
                    }
                )
                // containerCard.alpha = 0.1f

                containerMask.setOnClickListener {
                    listener.clickVisualizar(item, it)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup, listener: CardListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCardBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding, listener)
            }
        }
    }

}

class CardDiffUtil : DiffUtil.ItemCallback<CardModel>() {

    override fun areItemsTheSame(oldItem: CardModel, newItem: CardModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CardModel, newItem: CardModel): Boolean {
        return oldItem == newItem
    }
}