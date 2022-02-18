package com.rolahsu.transitionanimationdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.rolahsu.transitionanimationdemo.ImageData.IMAGE_DRAWABLES

class GridAdapter(val listener: GridAdapterInterface) : RecyclerView.Adapter<GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_image, parent, false))
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(holder, listener)
    }

    override fun getItemCount(): Int {
        return IMAGE_DRAWABLES.size
    }
}

class GridViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val imageView: ImageView = view.findViewById(R.id.imageView)

    fun bind(holder: GridViewHolder, listener: GridAdapterInterface) {
        setImage()
        ViewCompat.setTransitionName(imageView, adapterPosition.toString())
        itemView.setOnClickListener {
            listener.onItemClicked(holder, adapterPosition)
        }
    }

    private fun setImage() {
        imageView.setImageResource(IMAGE_DRAWABLES[adapterPosition])
    }
}

interface GridAdapterInterface {
    fun onItemClicked(holder: GridViewHolder, position: Int)
}


