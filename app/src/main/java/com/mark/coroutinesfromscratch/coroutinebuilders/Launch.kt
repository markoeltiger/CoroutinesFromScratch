package com.mark.coroutinesfromscratch.coroutinebuilders

import com.mark.coroutinesfromscratch.dispatchers.Dispatchers
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.intrinsics.createCoroutineUnintercepted

fun launch(dispatchers: Dispatchers,function: suspend ()-> Unit){
    val completion=object : Continuation<Unit> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {

        }
    }
     val functionAsObject=function.createCoroutineUnintercepted(completion =completion )
    dispatchers.dispatch(
        functionAsObject.resumeWith(Result.success(Unit))
    )
}