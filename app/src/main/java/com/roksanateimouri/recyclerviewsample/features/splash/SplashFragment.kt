package com.roksanateimouri.recyclerviewsample.features.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.roksanateimouri.recyclerviewsample.R
import com.roksanateimouri.recyclerviewsample.base.BaseFragment
import com.roksanateimouri.recyclerviewsample.util.isNetworkAvailable


import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Splash fragment that decides witch page must be shown to the user based on internet connection
 *
 */
class SplashFragment : BaseFragment() {

    private val viewModel: SplashViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeErrorMessage(viewModel.getExceptionData())
        viewModel.getNextPageLiveData().observe(viewLifecycleOwner, Observer {
            findNavController().navigate(R.id.action_splashFragment_to_airlineListFragment)
        })
        Handler().postDelayed(
            { viewModel.decideNextView(isNetworkAvailable(requireContext())) },
            1500
        )
    }
}