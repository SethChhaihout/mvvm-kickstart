package com.planbcambodia.projectkickstart.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.planbcambodia.projectkickstart.app.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Panha Sakvisa on 4/25/2019.
 */
@Module
class AppModule {
    @Provides
    fun providesContext(application: App): Context {
        return application.applicationContext
    }
}