package com.example.mvpdemo.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpdemo.R
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.remote.DataFetcher
import com.example.mvpdemo.databinding.FragmentSportsBinding
import kotlinx.android.synthetic.main.fragment_sports.*

class SportsFragment : Fragment() {

    private lateinit var binding: FragmentSportsBinding
    private lateinit var sportViewModel: SportViewModel
    private val sportAdapter by lazy {
        SportAdapter {
            Toast.makeText(context, "Halo", Toast.LENGTH_SHORT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sportViewModel = ViewModelProvider(this).get(SportViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentSportsBinding>(
            inflater,
            R.layout.fragment_sports,
            container,
            false
        ).apply {
            lifecycleOwner = this@SportsFragment
            recyclerSports.layoutManager = LinearLayoutManager(context)
            recyclerSports.adapter = sportAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sportViewModel.sportLiveData.observe(viewLifecycleOwner, Observer {
            sportAdapter.updateData(it as MutableList<Sport>?)
        })
    }

    companion object {
        fun newInstance() = SportsFragment()
    }
}