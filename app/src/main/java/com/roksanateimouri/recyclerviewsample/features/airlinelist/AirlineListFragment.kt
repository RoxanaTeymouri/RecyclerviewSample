package com.roksanateimouri.recyclerviewsample.features.airlinelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.roksanateimouri.recyclerviewsample.R
import com.roksanateimouri.recyclerviewsample.base.BaseFragment
import com.roksanateimouri.recyclerviewsample.features.airlinelist.adapter.AirlineListAdapter
import kotlinx.android.synthetic.main.airline_list_fragment.*
import kotlinx.android.synthetic.main.item_toolbar_back.*

import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Shows a list of previously fetched [com.roksanateimouri.airline.sample.android.pojo]
 *
 */
class AirlineListFragment : BaseFragment() {

    private val viewModel: AirlineListViewModel by viewModel()
    private lateinit var adapter: AirlineListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.airline_list_fragment, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeErrorMessage(viewModel.getExceptionData())
        setUpRecyclerView()
        viewModel.getAirlineListLiveData().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        if (savedInstanceState == null)
            viewModel.getAirlins()
    }

    private fun setUpRecyclerView() {
        adapter = AirlineListAdapter()
        recycler.adapter = adapter
    }
}