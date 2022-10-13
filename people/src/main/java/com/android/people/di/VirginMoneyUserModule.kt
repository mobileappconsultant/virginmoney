package com.android.people.di

import com.android.people.data.remote.UsersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
open class VirginMoneyUserModule {
    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit): UsersApi {
        return retrofit.create(UsersApi::class.java)
    }
}
