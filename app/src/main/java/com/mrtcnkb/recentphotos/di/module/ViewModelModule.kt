package com.mrtcnkb.recentphotos.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrtcnkb.recentphotos.ViewModelFactory
import com.mrtcnkb.recentphotos.di.key.ViewModelKey
import com.mrtcnkb.recentphotos.viewmodel.VMPhotoListFragment
import com.mrtcnkb.recentphotos.viewmodel.VMPhotoDetailFragment
import com.mrtcnkb.recentphotos.viewmodel.VMMainActivity
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(VMMainActivity::class)
    abstract fun provideVMMainActivity(activityViewModel: VMMainActivity): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(VMPhotoListFragment::class)
    abstract fun provideVMPhotoListFragment(photoListViewModel: VMPhotoListFragment): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(VMPhotoDetailFragment::class)
    abstract fun provideVMPhotoDetailFragment(photoDetailViewModel: VMPhotoDetailFragment): ViewModel
}