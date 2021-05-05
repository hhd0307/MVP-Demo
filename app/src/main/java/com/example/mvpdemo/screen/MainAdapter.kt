package com.example.mvpdemo.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvpdemo.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpdemo.data.model.Sport
import kotlinx.android.synthetic.main.item_sport.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder?>() {
    private val sports = mutableListOf<Sport>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_sport, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sports.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sports[position])
    }

    fun updateData(sports: MutableList<Sport>?) {
        sports?.let {
            this.sports.clear()
            this.sports.addAll(it)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(sport: Sport) {
            with(itemView) {
                tvName.text = sport.name
                tvDescription.text = sport.description
                applyImage(sport.thumbnail)
            }
        }

        private fun applyImage(strUrl: String) {
            Glide.with(itemView.context)
                    .load(strUrl)
                    .override(100,100)
                    .into(itemView.ivThumbnail)
        }
    }
}