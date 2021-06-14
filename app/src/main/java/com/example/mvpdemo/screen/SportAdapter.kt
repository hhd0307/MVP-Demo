package com.example.mvpdemo.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpdemo.R
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.databinding.ItemSportBinding
import com.example.mvpdemo.utils.loadImage
import kotlinx.android.synthetic.main.item_sport.view.*

class SportAdapter(
    private var clickListener: (Sport) -> Unit
) : RecyclerView.Adapter<SportAdapter.ViewHolder?>() {

    private val sports = mutableListOf<Sport>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemSportBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_sport,
            parent,
            false
        )
        return ViewHolder(binding, clickListener)
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
        private val binding: ItemSportBinding,
        private val onItemClicked: (Sport) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.sportViewModel = ItemSportViewModel()
        }

        fun bind(sport: Sport) {
            binding.apply {
                sportViewModel?.sport = sport
                executePendingBindings()
            }
        }
    }
}