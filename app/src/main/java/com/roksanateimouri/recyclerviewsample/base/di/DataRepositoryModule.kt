package com.roksanateimouri.recyclerviewsample.base.di


import com.roksanateimouri.recyclerviewsample.repository.DataRepository
import com.roksanateimouri.recyclerviewsample.repository.DataRepositoryInterface
import com.roksanateimouri.recyclerviewsample.repository.network.NetworkRepository
import org.koin.dsl.module

/**
 * Represents module of koin that the scopes inside it creates instance of [DataRepository] & [NetworkRepository].
 * this module injects [NetworkRepository] in [DataRepository].
 */
val dataRepositoryModule = module {
    single<DataRepositoryInterface> {
        DataRepository(get())
    }

    single {
        NetworkRepository(get())
    }

}
