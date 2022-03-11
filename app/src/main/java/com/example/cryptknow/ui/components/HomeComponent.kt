package com.example.cryptknow.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.coinloreapi.models.GlobalCoinResponse
import com.example.coinloreapi.repository.GlobalCoinRepository
import com.example.cryptknow.utils.stateManagement.NetworkUIState
import com.example.cryptknow.utils.stateManagement.NetworkingState.networkUiState

@Composable
fun HomeItems(coinRepository: GlobalCoinRepository){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val coinState by produceState(initialValue = NetworkUIState<GlobalCoinResponse>(isSuccessful = false, loading = true) ){
            val response = coinRepository.getGlobalCoin()
            value = networkUiState(response)
        }
        if(coinState.loading){
            Text(text = "loading")
        }

        if(coinState.isSuccessful){
            Text(
                coinState.response?.toString()!!
            )
        }

    }

}