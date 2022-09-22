package com.magdy.cryptocurrencyapp.presentation.ui.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.magdy.cryptocurrencyapp.presentation.Screen
import com.magdy.cryptocurrencyapp.presentation.ui.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    navController:NavController,
    viewModel: CoinListViewModel = hiltViewModel()

) {

    var state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
            items(state.coinsList) { coin ->
                CoinListItem(coin = coin, onItemClick =
                { coin ->
                    navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                }
                )
            }
        }
        if (state.errorMessage.isNotEmpty()) {
            Text(
                text = state.errorMessage,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
        if (state.isLoading){
            LinearProgressIndicator(
                color = Color.Green,
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}