package com.roksanateimouri.recyclerviewsample.base.di

import com.roksanateimouri.recyclerviewsample.features.airlinlist.AirlineListViewModel
import com.roksanateimouri.recyclerviewsample.features.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Represents instance of all ViewModels and injects [com.roksanateimouri.airline.sample.android.repository.DataRepository] in ViewModels.
 */
val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { AirlineListViewModel(get()) }
}
