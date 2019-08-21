package com.planbcambodia.projectkickstart.di.component

import android.app.Application
import com.planbcambodia.projectkickstart.app.App
import com.planbcambodia.projectkickstart.di.module.ActivitiesBindingModule
import com.planbcambodia.projectkickstart.di.module.AppModule
import com.planbcambodia.projectkickstart.di.module.NetworkModule
import com.planbcambodia.projectkickstart.di.viewmodelfactory.ViewModelBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Panha Sakvisa on 4/25/2019.
 */
@Singleton
@Component(
        modules = arrayOf(
                AndroidSupportInjectionModule::class,
                AppModule::class,
                NetworkModule::class,
                ActivitiesBindingModule::class,
                ViewModelBuilder::class
        )
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }
}