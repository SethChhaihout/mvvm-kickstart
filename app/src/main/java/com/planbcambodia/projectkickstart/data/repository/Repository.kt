package com.planbcambodia.projectkickstart.data.repository

import com.planbcambodia.projectkickstart.data.model.Service
import com.planbcambodia.projectkickstart.data.model.base.BaseModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Panha Sakvisa on 3/20/2019.
 */
interface Repository{
    @GET("service")
    fun getService(): Observable<BaseModel<List<Service>>>
}