
package com.roksanateimouri.recyclerviewsample.retrofit


import com.roksanateimouri.recyclerviewsample.pojo.model.AirlineItem
import retrofit2.http.GET

/**
 * Retrofit main interface
 *
 */
interface RetrofitInterface {

    @GET("/h/mobileapis/directory/airlines")
    suspend fun getAirline():  List<AirlineItem>
}