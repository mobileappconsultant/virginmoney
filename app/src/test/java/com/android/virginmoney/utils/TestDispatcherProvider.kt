package com.android.virginmoney.utils

import com.android.core.utils.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

@ExperimentalCoroutinesApi
class TestDispatcherProvider : DispatcherProvider {
    override val io: CoroutineDispatcher
        get() = UnconfinedTestDispatcher()
    override val default: CoroutineDispatcher
        get() = UnconfinedTestDispatcher()
    override val main: CoroutineDispatcher
        get() = UnconfinedTestDispatcher()
    override val unconfined: CoroutineDispatcher
        get() = UnconfinedTestDispatcher()
}
