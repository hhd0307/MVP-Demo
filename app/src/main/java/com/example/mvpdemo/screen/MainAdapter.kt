package com.example.mvpdemo.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvpdemo.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_sport.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder?>() {
    private val sports = mutableListOf<Sport>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Sport>? = null

    fun registerItemRecyclerViewClickListener(
            onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Sport>?) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_sport, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int = sports.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(sports[position])

    fun updateData(sports: MutableList<Sport>?) {
        sports?.let {
            this.sports.clear()
            this.sports.addAll(it)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(
            itemView: View,
            private val itemListener: OnItemRecyclerViewClickListener<Sport>?
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<Sport>? = null

        fun bind(sport: Sport) {
            with(itemView) {
                textName.text = sport.name
                textDescription.text = sport.description
                applyImage(sport.thumbnail.toString())
                listener = itemListener
                setOnClickListener(this@ViewHolder)
            }
        }

        private fun applyImage(strUrl: String) {
            Glide.with(itemView.context)
                    .load(strUrl)
                    .into(itemView.imageThumbnail)
        }

        override fun onClick(v: View?) {
            listener?.onItemClickListener(sports[adapterPosition])
        }
    }
}