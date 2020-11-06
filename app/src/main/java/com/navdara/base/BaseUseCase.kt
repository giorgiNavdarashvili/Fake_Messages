package com.navdara.base

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlin.coroutines.CoroutineContext

typealias SimpleResult = Result<Entity, Error>

abstract class BaseUseCase<in Params>: CoroutineScope {

    private val parentJob = SupervisorJob()
    private val mainDispatcher = Dispatchers.Main
    private val backgroundDispatcher = Dispatchers.Default
    protected val resultChannel = Channel<SimpleResult>()

    val receiveChannel: ReceiveChannel<SimpleResult> = resultChannel

    override val coroutineContext: CoroutineContext
        get() = parentJob + mainDispatcher

    protected abstract suspend fun run(params: Params)

    operator fun invoke(params: Params) {
        launch {
            withContext(backgroundDispatcher) {
                run(params)
            }
        }
    }

    protected fun <T> startAsync(block: suspend () -> T): Deferred<T> = async(parentJob) {
        block()
    }

    fun clear() {
        resultChannel.close()
        parentJob.cancel()
    }

    class None : Any()

}