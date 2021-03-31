package com.ruialmeida.quarentilograms.features.splash

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.sdk.network.service.provider.IServiceProvider
import com.ruialmeida.quarentilograms.sdk.network.service.service.LoginService
import com.ruialmeida.quarentilograms.sdk.persistence.database.QuarentilogramsDatabase
import com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.user.IUserLocalDataSource
import com.ruialmeida.quarentilograms.sdk.persistence.localdatasource.user.UserLocalDataSource
import org.koin.android.ext.android.inject

class SplashActivity : Activity() {
    private val database: QuarentilogramsDatabase by inject()
    private val database2: QuarentilogramsDatabase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<TextView>(R.id.activity_login_button).setOnClickListener {

            val list = listOf("1", "2")

            list.forEachIndexed { index, s ->

            }

            list.forEach {
                
            }

            list.filter { it.isNotBlank() }

            list.map { Log.d("asdf", "$it")}


            for (i in 0 until 3)
                println(i)
        }

    }
}