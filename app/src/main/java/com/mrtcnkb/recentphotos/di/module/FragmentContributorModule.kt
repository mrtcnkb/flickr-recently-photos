package com.mrtcnkb.recentphotos.di.module

import com.mrtcnkb.recentphotos.di.scope.FragmentScope
import com.mrtcnkb.recentphotos.ui.view.PhotoListFragment
import com.mrtcnkb.recentphotos.ui.view.PhotoDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * [FragmentContributorModule] is used inside [ContributorModule]
 * With @ContributesAndroidInjector(modules = FragmentContributorModule.class)
 * defines which module will be used to inject objects to declared fragments
 */
@Module
abstract class FragmentContributorModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributePhotoListFragment(): PhotoListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributePhotoDetailFragment(): PhotoDetailFragment


}