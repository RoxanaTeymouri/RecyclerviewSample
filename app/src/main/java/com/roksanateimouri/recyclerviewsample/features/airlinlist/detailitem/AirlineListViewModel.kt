package com.roksanateimouri.recyclerviewsample.features.airlinlist.detailitem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.roksanateimouri.recyclerviewsample.base.BaseViewModel
import com.roksanateimouri.recyclerviewsample.pojo.model.AirlineItem
import com.roksanateimouri.recyclerviewsample.retrofit.RetrofitInterface
import com.roksanateimouri.recyclerviewsample.util.coroutinesExceptionHandler
import kotlinx.coroutines.launch

/**
 * Fetches data needed by the VehicleList page
 *
 * @property repository
 */
class AirlineListViewModel(private val repository: RetrofitInterface) : BaseViewModel() {
    private val liveData = MutableLiveData<List<AirlineItem>>()

    fun getAirlins() = viewModelScope.launch(coroutinesExceptionHandler(exceptionLiveData)) {
        val data = repository.getAirline()
        liveData.postValue(data)
    }
    fun getAirlineListLiveData(): LiveData<List<AirlineItem>> = liveData
}