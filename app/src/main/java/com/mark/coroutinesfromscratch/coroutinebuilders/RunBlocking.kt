package com.mark.coroutinesfromscratch.coroutinebuilders
import kotlin.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.intrinsics.createCoroutineUnintercepted

fun runBlocking(function:suspend()->Unit){
    val callback = object :Continuation<Unit>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {

        }}

    val functionAsObject : Continuation<Unit> =
    function.createCoroutineUnintercepted(callback)
    functionAsObject.resumeWith(Result.success(Unit))
}