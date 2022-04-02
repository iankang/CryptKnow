package com.example.cryptknow.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coinloreapi.models.Data
import com.example.cryptknow.ui.theme.CryptKnowTheme
import java.text.NumberFormat
import java.util.*


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
    CoinCardsPreview(
        rank = item.rank.toString(),
        coinSymbol = item.symbol,
        coinName = item.name,
        priceBTC = item.priceBtc,
        priceDollar = item.priceUsd,
        marketCap = item.marketCapUsd,
        percentageChange = item.percentChange1h
    )
}

@Composable
fun CoinCardsPreview(
    rank:String = "1",
    coinSymbol:String = "ETH",
    coinName:String = "Ethereum",
    priceBTC:String = "0.837282838",
    priceDollar:String ="$8,283,792",
    marketCap:String = "$3,434,344,343",
    percentageChange:String = "0.24"

) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(0.25.dp,MaterialTheme.colors.onPrimary.copy(alpha = 0.4f)),
        elevation = 8.dp
    ) {
       Column(
           modifier = Modifier.fillMaxWidth(),
           verticalArrangement = Arrangement.Center
       ) {
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(56.dp)
                   .padding(horizontal = 16.dp),
               verticalAlignment = Alignment.Top
           ) {


               Icon(
                   imageVector = Icons.Rounded.Home,
                   contentDescription = "default image",
                   modifier = Modifier.size(72.dp)
               )


               Box(
                   modifier = Modifier.height(72.dp),
                   contentAlignment = Alignment.Center
               ) {

                   Column(
                       verticalArrangement = Arrangement.SpaceAround
                   ) {
                       Text(
                           text = "#$rank $coinSymbol",
                           style = MaterialTheme.typography.subtitle2,
                           overflow = TextOverflow.Ellipsis
                       )
                       Text(
                           text = "$coinName",
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
                   Column(
                       verticalArrangement = Arrangement.SpaceAround,
                       horizontalAlignment = Alignment.End
                   ) {
                       Text(
                           text = String.format(priceBTC,"%.f"),
                           style = MaterialTheme.typography.subtitle2,
                           overflow = TextOverflow.Ellipsis
                       )
                       Text(
                           text = NumberFormat.getCurrencyInstance(Locale.US).format(priceDollar.toBigDecimal()),
                           modifier = Modifier.align(Alignment.End),
                           fontWeight = FontWeight.Light,
                           style = MaterialTheme.typography.caption
                       )
                   }
               }
           }

           Divider(
               modifier = Modifier.fillMaxWidth().padding(end = 16.dp),
               color = MaterialTheme.colors.onPrimary.copy(alpha = 0.4f),
               thickness = 0.5.dp,
               startIndent = 88.dp
           )

           Row (
               modifier =  Modifier
                   .fillMaxWidth()
                   .padding(
                       PaddingValues(start = 88.dp, top = 8.dp, end = 16.dp)
                   ),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ){
               Text(
                   text = NumberFormat.getCurrencyInstance(Locale.US).format(marketCap.toBigDecimal()),
                   style = MaterialTheme.typography.subtitle2,
                   overflow = TextOverflow.Ellipsis
               )

               Text(
                   text = String.format(percentageChange,"%.2f %"),
                   color = if(percentageChange.toFloat() > 0)Color.Green.copy(alpha = 0.5f) else Color.Red.copy(alpha = 0.5f),
                   style = MaterialTheme.typography.subtitle2,
                   overflow = TextOverflow.Ellipsis
               )

           }
       }
    }

}

@Composable
@Preview(showBackground = true, name = "day")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "night")
fun ActualCoinCardPreview(){
    CryptKnowTheme{
        CoinCardsPreview()
    }
}