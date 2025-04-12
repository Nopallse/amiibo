package com.example.core.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.R
import com.example.core.databinding.ItemListAmiiboBinding
import com.example.core.domain.model.Amiibo
import com.bumptech.glide.Glide

class AmiiboAdapter : ListAdapter<Amiibo, AmiiboAdapter.ListViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((Amiibo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            ItemListAmiiboBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(private var binding: ItemListAmiiboBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Amiibo) {
            Glide.with(itemView.context)
                .load(data.image)
                .into(binding.ivItemImage)
            binding.tvItemTitle.text = data.name
            binding.tvItemSubtitle.text = data.amiiboSeries
            binding.tvItemType.text = data.type
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Amiibo> =
            object : DiffUtil.ItemCallback<Amiibo>() {
                override fun areItemsTheSame(oldItem: Amiibo, newItem: Amiibo): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Amiibo, newItem: Amiibo): Boolean {
                    return oldItem == newItem
                }
            }
    }
}