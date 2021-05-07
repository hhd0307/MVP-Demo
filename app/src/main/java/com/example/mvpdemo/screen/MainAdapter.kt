package com.example.mvpdemo.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvpdemo.R
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.utils.loadImage
import kotlinx.android.synthetic.main.item_sport.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder?>() {
    private val sports = mutableListOf<Sport>()
    private lateinit var clickListener: (Sport) -> Unit

    fun registerItemRecyclerViewClickListener(onItemRecyclerViewClickListener: (Sport) -> Unit) {
        clickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_sport, parent, false)
        return ViewHolder(view, clickListener)
    }

    override fun getItemCount() = sports.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(sports[position])

    fun updateData(sports: MutableList<Sport>?) {
        sports?.let {
            this.sports.clear()
            this.sports.addAll(it)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(
            itemView: View,
            private val onItemClicked: (Sport) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(sport: Sport) {
            with(itemView) {
                textName.text = sport.name
                textDescription.text = sport.description
                imageThumbnail.loadImage(sport.thumbnail.toString())
                setOnClickListener { onItemClicked(sport) }
            }
        }
    }
}
