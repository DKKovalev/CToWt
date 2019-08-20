package com.dkkovalev.ctowt.presentation.screen.streams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dkkovalev.ctowt.R
import com.dkkovalev.ctowt.data.model.entity.StreamItem
import com.squareup.picasso.Picasso

class StreamsAdapter(private val itemClickListener: (item: StreamItem, view: ImageView) -> Unit) :
    ListAdapter<StreamItem, StreamViewHolder>(StreamDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StreamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.browse_item, parent, false)
        return StreamViewHolder(view)
    }

    override fun onBindViewHolder(holder: StreamViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickListener)
    }
}

class StreamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvName: TextView = itemView.findViewById(R.id.tv_name)
    private val ivThumbnail: ImageView = itemView.findViewById(R.id.iv_thumbnail)

    fun bind(item: StreamItem, itemClickListener: (item: StreamItem, view: ImageView) -> Unit) {
        itemView.setOnClickListener { itemClickListener(item, ivThumbnail) }

        tvName.text = item.streamName
        Picasso.get()
            .load(item.thumbnailUrl)
            .fit()
            .centerCrop()
            .placeholder(R.color.placeholder)
            .into(ivThumbnail)
    }
}

class StreamDiffUtil : DiffUtil.ItemCallback<StreamItem>() {
    override fun areItemsTheSame(oldItem: StreamItem, newItem: StreamItem): Boolean = true

    override fun areContentsTheSame(oldItem: StreamItem, newItem: StreamItem): Boolean = true
}