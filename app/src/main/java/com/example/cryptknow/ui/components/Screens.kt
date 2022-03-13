package com.example.cryptknow.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.coinloreapi.models.CoinLoreResponse
import com.example.coinloreapi.models.CoinsTickersResponse
import com.example.coinloreapi.repository.CoinLoreApi
import com.example.cryptknow.R

@Composable
fun MusicScreen(coinLoreApi: CoinLoreApi) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
            .wrapContentSize(Alignment.Center)
    ) {
        val coinState = produceState(initialValue = CoinLoreResponse<CoinsTickersResponse>()){
            value = coinLoreApi.getCoinsTickers()
        }
        if(coinState.value.isOk == true) {
            CardList(coinState.value.data?.data)
        }else{
            Loader()
        }
    }
}


@Composable
fun MoviesScreen(coinLoreApi: CoinLoreApi) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Movies View",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.crypto))
    LottieAnimation(composition)
}
