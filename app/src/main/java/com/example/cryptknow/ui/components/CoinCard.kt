package com.example.cryptknow.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coinloreapi.models.Data


@Composable
fun CardList(data: List<Data>?) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
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
            .fillMaxWidth(0.8f)
            .height(120.dp),
        shape =  RoundedCornerShape(3.dp),
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
            Text(
                item.name
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun CoinCardPreview(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        backgroundColor = MaterialTheme.colors.primarySurface,
        contentColor = MaterialTheme.colors.onPrimary,
        elevation = 4.dp
    ) {
        Surface(
            modifier = Modifier
                .padding(4.dp),
            contentColor = MaterialTheme.colors.onPrimary
        ){
            Text(
                "Bitcoin"
            )
        }
    }
}