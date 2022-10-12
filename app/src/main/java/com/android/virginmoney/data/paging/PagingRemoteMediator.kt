package com.android.virginmoney.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator

@OptIn(ExperimentalPagingApi::class)
class PagingRemoteMediator() : RemoteMediator<Int, Any>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Any>
    ): MediatorResult {
        TODO()
    }

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }
}
