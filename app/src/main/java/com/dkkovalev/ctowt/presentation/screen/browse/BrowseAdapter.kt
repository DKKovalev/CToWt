package com.dkkovalev.ctowt.presentation.screen.browse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dkkovalev.ctowt.R
import com.dkkovalev.ctowt.data.model.entity.BrowseItem
import com.squareup.picasso.Picasso

class BrowseAdapter(private val itemClickListener: (item: BrowseItem, view: ImageView) -> Unit) :
    ListAdapter<BrowseItem, BrowseViewHolder>(BrowseDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.browse_item, parent, false)
        return BrowseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrowseViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickListener)
    }
}

class BrowseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvName: TextView = itemView.findViewById(R.id.tv_name)
    private val ivThumbnail: ImageView = itemView.findViewById(R.id.iv_thumbnail)

    fun bind(item: BrowseItem, itemClickListener: (item: BrowseItem, view: ImageView) -> Unit) {
        itemView.setOnClickListener { itemClickListener(item, ivThumbnail) }

        tvName.text = item.name
        Picasso.get()
            .load(item.thumbnail)
            .fit()
            .centerCrop()
            .placeholder(R.color.placeholder)
            .into(ivThumbnail)
    }
}

class BrowseDiffUtil : DiffUtil.ItemCallback<BrowseItem>() {
    override fun areItemsTheSame(oldItem: BrowseItem, newItem: BrowseItem): Boolean = oldItem.mixerId == newItem.mixerId
            && oldItem.twitchId == newItem.twitchId

    override fun areContentsTheSame(oldItem: BrowseItem, newItem: BrowseItem): Boolean = oldItem.name == newItem.name
}