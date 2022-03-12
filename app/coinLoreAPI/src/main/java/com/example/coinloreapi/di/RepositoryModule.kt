package com.example.coinloreapi.di

import com.example.coinloreapi.repository.GlobalCoinRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { provideGlobalCoinRepository() }
}

fun provideGlobalCoinRepository():GlobalCoinRepository{
    return GlobalCoinRepository()
}