package com.planbcambodia.projectkickstart.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.planbcambodia.projectkickstart.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerActivity
import dagger.android.DaggerApplication

/**
 * Created by Panha Sakvisa on 3/21/2019.
 */
class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .create(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}