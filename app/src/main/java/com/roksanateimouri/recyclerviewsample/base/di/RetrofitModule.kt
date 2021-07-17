package com.roksanateimouri.recyclerviewsample.base.di

import com.roksanateimouri.recyclerviewsample.retrofit.RetrofitInterface
import com.roksanateimouri.recyclerviewsample.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val retrofitModule = module {

    single {
        /**
         * Provides and configs logger to see the logs in terminal.
         */
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor
    }
    single {
        /**
         * Provides base url.
         */
        BASE_URL
    }

    single {
        /**
         * Provides and configs httpClient.
         */
        val httpClient = OkHttpClient().newBuilder()
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.callTimeout(30, TimeUnit.SECONDS)
        httpClient.addInterceptor(get<HttpLoggingInterceptor>())
        httpClient
    }

    single {
        /**
         * Provides the retrofit object.
         */
        Retrofit.Builder()
            .baseUrl(get<String>())
            .addConverterFactory(get<MoshiConverterFactory>())
            .client(get<OkHttpClient.Builder>().build())
            .build()
    }

    single {
        /**
         * Provides the retrofit interface.
         */
        get<Retrofit>().create(RetrofitInterface::class.java)
    }
}
