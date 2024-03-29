package br.com.killkinto.mvvm_breeds.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors constructor(val mainThreadExecutor: Executor = MainThreadExecutor(),
                               val roomThreadExecutor: Executor = RoomIOThreadExecutor())

private class RoomIOThreadExecutor : Executor {
    private val executor = Executors.newSingleThreadExecutor()
    override fun execute(command: Runnable) {
        executor.execute(command)
    }
}

private class MainThreadExecutor : Executor {
    private val handler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        handler.post(command)
    }
}