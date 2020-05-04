package com.mrtcnkb.recentphotos.di.module

import com.mrtcnkb.recentphotos.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContributorModule {


    /**
    Defines which fragments will be used by [MainActivity]
     */
    @ContributesAndroidInjector(modules = [FragmentContributorModule::class])
    abstract fun contributeMainActivity(): MainActivity
}