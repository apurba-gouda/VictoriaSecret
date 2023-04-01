package com.example.victoriasecret.data

import com.example.victoriasecret.data.model.Status
import kotlinx.coroutines.flow.*
import javax.inject.Inject

open class CompositeRepo<D>
@Inject
constructor() : Repo<D> {
    private val mutableValueStream = MutableStateFlow<D?>(null)
    override val values: Flow<D?> get() = mutableValueStream

    private val mutableStatusStream = MutableStateFlow(Status.LOADING)
    override val statusStream: Flow<Status> get() = mutableStatusStream

    override val lastValue: D? get() = mutableValueStream.value
    override val lastStatus: Status get() = mutableStatusStream.value

    override suspend fun update(refreshFunction: suspend () -> D) {
        mutableStatusStream.value = Status.LOADING
        try {
            val value = refreshFunction()
            mutableValueStream.value = value
            mutableStatusStream.value = Status.LIVE
        } catch (e: Exception) {
            mutableStatusStream.value = Status.ERROR
            throw Exception("Exception while refreshing repo with reason: ${e.message}")
        }
    }
}