package com.example.cryptknow

import android.app.Application
import com.example.coinloreapi.di.coinLoreModule
import com.example.coinloreapi.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CryptKnow:Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(applicationContext)
            modules(listOf(
                coinLoreModule,
                repositoryModule
            ))
        }
    }
}