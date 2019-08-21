package com.planbcambodia.projectkickstart.utils

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Panha Sakvisa on 3/21/2019.
 */
class ApiModelHelper{
    companion object {
        fun <T>observe(observable: Observable<T>): Observable<T> {
            return observable
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
        }
    }
}