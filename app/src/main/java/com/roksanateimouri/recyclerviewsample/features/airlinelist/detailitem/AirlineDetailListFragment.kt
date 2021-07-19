package com.roksanateimouri.recyclerviewsample.features.airlinelist.detailitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.roksanateimouri.recyclerviewsample.R
import com.roksanateimouri.recyclerviewsample.base.BaseFragment
import com.roksanateimouri.recyclerviewsample.features.airlinelist.AirlineListViewModel
import com.roksanateimouri.recyclerviewsample.util.BASE_URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.airline_list_fragment.*
import kotlinx.android.synthetic.main.airline_list_item.*
import kotlinx.android.synthetic.main.fragment_airline_list_item_detail.*
import kotlinx.android.synthetic.main.item_toolbar_back.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Shows a list of previously fetched [com.roksanateimouri.airline.sample.android.pojo]
 *
 */
class AirlineDetailListFragment : BaseFragment() {

    private val viewModel: AirlineListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_airline_list_item_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        iv_close.visibility=View.VISIBLE
        txtTitle.text = arguments?.getString("name")
        observeErrorMessage(viewModel.getExceptionData())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_airline_name.text = arguments?.getString("name")
        tv_url.text = arguments?.getString("url")
        tv_phone.text = arguments?.getString("phone")
        Picasso.get().load( BASE_URL + arguments?.getString("logo")).into(iv_logo)

        iv_close.setOnClickListener{
            findNavController().navigate(R.id.action_airlineListDetailFragment_to_airlineListFragment)
        }
    }
}