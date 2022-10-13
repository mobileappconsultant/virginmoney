package com.android.people.di

import com.android.people.data.repository.local.LocalRepository
import com.android.people.data.repository.local.LocalRepositoryImpl
import com.android.people.data.repository.remote.RemoteRepository
import com.android.people.data.repository.remote.RemoteRepositoryImpl
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
