package com.example.cryptknow.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coinloreapi.models.Data
import com.example.cryptknow.utils.stateManagement.StringUtils.prettyCount


@Composable
fun CardList(data: List<Data>?) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(data!!){ item ->
            CoinListItem(item)
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
fun CoinListItem(item: Data){
    CoinCardPreview(
        rank = item.rank.toString(),
        coin = item.name,
        marketCap = item.marketCapUsd,
        percentageChange = item.percentChange1h
    )
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun CoinCardPreview(
    rank:String = "1",
    coin:String = "Bitcoin",
    marketCap:String = "3434344343",
    percentageChange:String = "24"

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.Top
    ) {

        Box(
            modifier = Modifier.size(72.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = "default image",
                modifier = Modifier.size(48.dp)
            )
        }

        Box(
            modifier = Modifier.height(72.dp),
            contentAlignment = Alignment.Center
        ) {

            Column(
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "#$rank $coin",
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${prettyCount(marketCap.toBigDecimal())}",
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.caption
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
                Text(
                    text = "$percentageChange %",
                    style = MaterialTheme.typography.body1
                )
        }
    }


}