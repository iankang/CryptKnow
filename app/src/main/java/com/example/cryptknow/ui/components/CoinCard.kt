package com.example.cryptknow.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coinloreapi.models.Data


@Composable
fun CardList(data: List<Data>?) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(data!!){ item ->
            CoinCard(item)
        }
    }
}

@Composable
fun CoinCard(item: Data) {
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
        ){
            Column(
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Rank: #${item.rank}",
                        color = MaterialTheme.colors.onSurface
                    )

                    Text(
                        "${item.name}",
                        color = MaterialTheme.colors.onSurface
                    )
                    Text(
                        "Symbol: ${item.symbol}",
                        color = MaterialTheme.colors.onSurface
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "MarketCap ($): ${item.marketCapUsd}",
                        color = MaterialTheme.colors.onSurface
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "CoinSupply: ${item.csupply}",
                        color = MaterialTheme.colors.onSurface
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Price: ${item.priceBtc}",
                        color = MaterialTheme.colors.onSurface
                    )

                    Text(
                        "Price USD: ${item.priceUsd}",
                        color = MaterialTheme.colors.onSurface
                    )

                }
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun CoinCardPreview(){
    Card(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(120.dp),
        shape =  RoundedCornerShape(6.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onPrimary,
        elevation = 4.dp
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            shape = RoundedCornerShape(4.dp),
            contentColor = MaterialTheme.colors.onPrimary
        ){
            Column(
                verticalArrangement = Arrangement.SpaceEvenly
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Rank: #1",
                        color = MaterialTheme.colors.onSurface
                    )

                    Text(
                        "Bitcoin",
                        color = MaterialTheme.colors.onSurface
                    )
                    Text(
                        "Symbol",
                        color = MaterialTheme.colors.onSurface
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "MarketCap: 9234",
                        color = MaterialTheme.colors.onSurface
                    )

                    Text(
                        "CoinSupply: $3434",
                        color = MaterialTheme.colors.onSurface
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Price: 9234",
                        color = MaterialTheme.colors.onSurface
                    )

                    Text(
                        "Price USD: $3434",
                        color = MaterialTheme.colors.onSurface
                    )

                }
            }

        }
    }
}