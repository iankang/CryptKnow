package com.example.coinloreapi.di

import com.example.coinloreapi.api.CoinLoreAPI
import com.example.coinloreapi.repository.GlobalCoinRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { provideGlobalCoinRepository(get()) }
}

fun provideGlobalCoinRepository(coinLoreAPI: CoinLoreAPI):GlobalCoinRepository{
    return GlobalCoinRepository(coinLoreAPI)
}