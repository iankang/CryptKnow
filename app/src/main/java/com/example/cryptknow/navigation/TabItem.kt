package com.example.cryptknow.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinloreapi.repository.CoinLoreApi
import com.example.cryptknow.ui.components.MoviesScreen
import com.example.cryptknow.ui.components.MusicScreen

typealias ComposableFun = @Composable (coinLoreApi: CoinLoreApi) -> Unit

sealed class TabItem(var icon: ImageVector, var title: String, var screen: ComposableFun) {
    object Music : TabItem(Icons.Rounded.Home, "Home", { MusicScreen(coinLoreApi = it) })
    object Movies : TabItem(Icons.Rounded.MailOutline, "Movies", { MoviesScreen(coinLoreApi = it) })
//    object Books : TabItem(Icons.Rounded.AccountCircle, "Books", { BooksScreen(coinLoreApi = it) })
}