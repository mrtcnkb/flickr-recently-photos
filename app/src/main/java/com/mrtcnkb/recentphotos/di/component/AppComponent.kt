package com.mrtcnkb.recentphotos.di.component

import android.app.Application
import com.mrtcnkb.recentphotos.RecentPhotosApplication
import com.mrtcnkb.recentphotos.di.module.AppModule
import com.mrtcnkb.recentphotos.di.module.ContributorModule
import com.mrtcnkb.recentphotos.di.module.ViewModelModule
import com.muratcan.data.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ContributorModule::class,
        NetworkModule::class
    ]
)

interface AppComponent: AndroidInjector<RecentPhotosApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: RecentPhotosApplication?)
}