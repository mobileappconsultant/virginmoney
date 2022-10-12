package com.android.virginmoney

import com.android.virginmoney.utils.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher

class TestDispatcherProvider : DispatcherProvider {
    override val io: CoroutineDispatcher
        get() = UnconfinedTestDispatcher()
}
