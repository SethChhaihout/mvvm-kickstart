package com.planbcambodia.projectkickstart.di.module

import android.arch.lifecycle.ViewModel
import com.planbcambodia.projectkickstart.di.viewmodelfactory.ViewModelKey
import com.planbcambodia.projectkickstart.view.ui.activity.MainActivity
import com.planbcambodia.projectkickstart.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Panha Sakvisa on 4/25/2019.
 */
@Module
internal abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}