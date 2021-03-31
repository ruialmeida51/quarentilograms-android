package com.ruialmeida.quarentilograms

import android.app.Application
import android.util.Log
import com.ruialmeida.quarentilograms.sdk.SdkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class QuarentilogramsApp : Application() {

    companion object {
        private const val TAG = "QuarentilogramsApp"
    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        Log.d(TAG, "Setting up koin...")

        startKoin {
            androidLogger()
            androidContext(androidContext = this@QuarentilogramsApp)
            modules(modules = AppModule.getModules() + SdkModule.getModules())
        }
    }
}