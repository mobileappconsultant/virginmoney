package com.android.virginmoney.di

import com.android.core.utils.DefaultDispatcherProvider
import com.android.core.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
open class AppModule {

    open fun getDispatchers(): DispatcherProvider = DefaultDispatcherProvider()

    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): DispatcherProvider {
        return getDispatchers()
    }

    companion object {
        private const val CONNECT_TIMEOUT = 10L
    }
}
