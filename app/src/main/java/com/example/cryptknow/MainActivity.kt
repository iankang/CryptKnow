package com.example.cryptknow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.coinloreapi.repository.GlobalCoinRepository
import com.example.cryptknow.ui.components.HomeItems
import com.example.cryptknow.ui.theme.CryptKnowTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val coinRepository:GlobalCoinRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptKnowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeItems(coinRepository = coinRepository)
                }
            }
        }
    }
}

