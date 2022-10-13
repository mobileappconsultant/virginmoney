package com.android.virginmoney.di

import com.android.virginmoney.TestDispatcherProvider
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
class FakeNetworkModule : NetworkModule() {
    override fun getBaseUrl() = "http://localhost:8080/"
    override fun getDispatchers() = TestDispatcherProvider()
}
