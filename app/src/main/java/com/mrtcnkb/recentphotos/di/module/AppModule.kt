package com.mrtcnkb.recentphotos.di.module

import android.app.Application
import android.content.Context
import com.mrtcnkb.recentphotos.di.qualifiers.ApplicationContextQualifier
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @ApplicationContextQualifier
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}