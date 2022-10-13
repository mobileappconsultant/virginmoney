package com.android.rooms.di

import com.android.rooms.data.repository.local.LocalRepository
import com.android.rooms.data.repository.local.LocalRepositoryImpl
import com.android.rooms.data.repository.remote.RemoteRepository
import com.android.rooms.data.repository.remote.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLocalRepository(localRepositoryImpl: LocalRepositoryImpl): LocalRepository

    @Binds
    abstract fun bindRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository
}
