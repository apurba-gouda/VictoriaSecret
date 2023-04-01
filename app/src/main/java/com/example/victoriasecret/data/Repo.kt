package com.example.victoriasecret.data

import kotlinx.coroutines.flow.Flow
import com.example.victoriasecret.data.model.Status

interface Repo<D> {
    val values: Flow<D?>
    val statusStream: Flow<Status>

    val lastValue: D?
    val lastStatus: Status

    // Here it will update the Flow<D> and Flow<Status>
    suspend fun update(refreshFunction: suspend () -> D)
}