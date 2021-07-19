package com.roksanateimouri.recyclerviewsample.features.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.roksanateimouri.recyclerviewsample.base.BaseViewModel
import com.roksanateimouri.recyclerviewsample.pojo.model.AirlineItem
import com.roksanateimouri.recyclerviewsample.retrofit.RetrofitInterface
import com.roksanateimouri.recyclerviewsample.util.coroutinesExceptionHandler
import kotlinx.coroutines.launch

/**
 * Splash page ViewModel
 *
 * @property dataRepository
 */
class SplashViewModel(private val dataRepository: RetrofitInterface) : BaseViewModel() {

    private val liveData = MutableLiveData<List<AirlineItem>>()

    fun decideNextView(networkAvailable: Boolean) =
        viewModelScope.launch(coroutinesExceptionHandler(exceptionLiveData)) {
            liveData.postValue(
                when {
                    networkAvailable-> dataRepository.getAirline()
                    else ->  throw IllegalArgumentException("There is a problem in fetching data")
                }
            )
        }
    fun getNextPageLiveData(): LiveData<List<AirlineItem>> = liveData
}