package com.example.cryptknow.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coinloreapi.models.ExchangesItems

@Composable
fun exchangesList(exchangesItemsList: List<ExchangesItems>?) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
       items(exchangesItemsList!!){ item: ExchangesItems ->
           exchangeCard(exchangesItem = item)
       }
    }
}

@Composable
fun exchangeCard(exchangesItem: ExchangesItems) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(8.dp))
            .height(120.dp),
        shape =  RoundedCornerShape(12.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onPrimary,
        elevation = 8.dp
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            shape = RoundedCornerShape(4.dp),
            contentColor = MaterialTheme.colors.onPrimary
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(){
                    Text(
                        exchangesItem.name.orEmpty()
                    )
                }
                Row(){
                    Text(
                        "country: ${exchangesItem.country}"
                    )
                }
                Row(){
                    Text(
                        "volume ($): ${exchangesItem.volume_usd}"
                    )
                }

            }
        }
    }
}