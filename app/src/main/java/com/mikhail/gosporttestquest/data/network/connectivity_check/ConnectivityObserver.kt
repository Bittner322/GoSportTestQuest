package com.mikhail.gosporttestquest.data.network.connectivity_check

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    fun observe(): Flow<Status>

    sealed class Status {
        data object Available: Status()
        data object Unavailable: Status()
        data object Losing: Status()
        data object Lost: Status()
    }
}