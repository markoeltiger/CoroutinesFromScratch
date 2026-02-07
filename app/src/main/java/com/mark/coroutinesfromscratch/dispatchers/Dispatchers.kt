package com.mark.coroutinesfromscratch.dispatchers

import android.os.Looper
import java.util.logging.Handler

abstract class Dispatchers {
    abstract fun  dispatch(block: Runnable)
    object Default : Dispatchers(){
        private val threadPool = java.util.concurrent.Executors.newFixedThreadPool(8)
        override fun dispatch(block: Runnable) {
            threadPool.execute(block)
        }
        object Main : Dispatchers(){
            override fun dispatch(block: Runnable) = android.os.Handler(Looper.getMainLooper()).post(block)
        }
        object Unconfined : Dispatchers(){
            override fun dispatch(block: Runnable) = block.run()
        }


}
}

