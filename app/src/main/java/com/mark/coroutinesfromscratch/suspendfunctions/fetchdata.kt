package com.mark.coroutinesfromscratch.suspendfunctions

import kotlin.concurrent.thread
import kotlin.coroutines.intrinsics.*
import kotlin.coroutines.intrinsics.createCoroutineUnintercepted

suspend fun fetchData(){
    println("Hello fetching data")
    val result =suspendCoroutineUninterceptedOrReturn<String>{cont->
        thread { cont.resumeWith(Result.success("Some Data")) }
        return@suspendCoroutineUninterceptedOrReturn COROUTINE_SUSPENDED

    }
    println("Data fetched")

}