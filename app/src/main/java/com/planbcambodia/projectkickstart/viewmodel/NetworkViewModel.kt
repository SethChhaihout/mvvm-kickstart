package com.planbcambodia.projectkickstart.viewmodel

import android.arch.lifecycle.ViewModel
import com.planbcambodia.projectkickstart.data.model.base.BaseModel
import com.planbcambodia.projectkickstart.utils.ApiModelHelper
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Panha Sakvisa on 3/20/2019.
 */
open class NetworkViewModel : ViewModel() {
    private lateinit var subscription: CompositeDisposable

    init {
        onCreate()
    }

    private fun onCreate() {
        subscription = CompositeDisposable()
    }

    fun <T>callApi(api: Observable<BaseModel<T>>, onNext:((t: BaseModel<T>) -> Unit), onError:((t:Throwable) -> Unit)): Disposable{
        val apiObservable = ApiModelHelper.observe(api).subscribe(onNext,onError)
        addDisposable(apiObservable)
        return apiObservable
    }

    private fun addDisposable(d: Disposable){
        subscription?.add(d)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}