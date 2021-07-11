package com.example.android.memeappusingrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemeListAdapter(private val items:ArrayList<String>,private val listener:MemeItemCLicked): RecyclerView.Adapter<MemeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.meme_image,parent,false)
        val viewHolder = MemeViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class MemeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView : TextView = itemView.findViewById(R.id.title)
}

interface MemeItemCLicked{
    fun onItemClicked(item : String)
}
