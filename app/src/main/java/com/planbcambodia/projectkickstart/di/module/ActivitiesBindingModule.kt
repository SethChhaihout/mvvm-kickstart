package com.planbcambodia.projectkickstart.di.module

import com.planbcambodia.projectkickstart.view.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Panha Sakvisa on 4/25/2019.
 */
@Module
abstract class ActivitiesBindingModule {
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun mainActivity(): MainActivity
}