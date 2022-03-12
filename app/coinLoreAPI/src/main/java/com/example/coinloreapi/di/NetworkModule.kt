package com.example.coinloreapi.di

import com.example.coinloreapi.api.CoinLoreAPIRequests
import com.example.coinloreapi.utils.Constants.COIN_LORE_BASE_API
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val coinLoreModule = module {
    factory { provideOkHttpClientInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideRetrofit(get()) }
//    factory { interceptor }
    single { provideCoinLoreApi(get()) }

}


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(COIN_LORE_BASE_API)
        .build()
}

fun provideOkHttpClientInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}

val interceptor = Interceptor { chain ->
    val response = chain.proceed(chain.request())
    var locationHistory = mutableListOf<String>()
    locationHistory.add(response.header("Location")?: "empty")
    response
}


fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(interceptor)
        .build()
}

fun provideCoinLoreApi(retrofit: Retrofit):CoinLoreAPIRequests{
    return retrofit.create(CoinLoreAPIRequests::class.java)
}