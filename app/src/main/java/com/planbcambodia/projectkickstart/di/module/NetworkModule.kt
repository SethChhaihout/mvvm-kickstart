package com.planbcambodia.projectkickstart.di.module

import com.planbcambodia.projectkickstart.data.repository.Repository
import com.planbcambodia.projectkickstart.utils.Constant
import com.planbcambodia.projectkickstart.utils.Constant.baseAPIUrl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Panha Sakvisa on 3/20/2019.
 */
@Module
class NetworkModule{
    @Provides
    @Singleton
    internal fun provideRepository(retrofit: Retrofit):Repository{
        return retrofit.create(Repository::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRetrofitInterface():Retrofit{
        return Retrofit.Builder()
                .baseUrl(baseAPIUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}