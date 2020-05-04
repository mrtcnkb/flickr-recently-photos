package com.mrtcnkb.recentphotos

import com.mrtcnkb.recentphotos.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class RecentPhotosApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    init { instance = this }

    companion object {
        private var instance = RecentPhotosApplication()
    }
}