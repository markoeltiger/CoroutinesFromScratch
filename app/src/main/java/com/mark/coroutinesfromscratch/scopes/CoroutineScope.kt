package com.mark.coroutinesfromscratch.scopes

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

interface CoroutineScope {
    val coroutineContext: CoroutineContext
}
object GlobalScope: CoroutineScope{

    override val coroutineContext: CoroutineContext
        get() = EmptyCoroutineContext

}
object MainScope: CoroutineScope{

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob()+ Dispatchers.Main

}