package com.example.coinloreapi.di

import com.example.coinloreapi.repository.CoinLoreApi
import org.koin.dsl.module

val repositoryModule = module {
    single { provideGlobalCoinRepository() }
}

fun provideGlobalCoinRepository():CoinLoreApi{
    return CoinLoreApi()
}