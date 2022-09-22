package com.magdy.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.magdy.cryptocurrencyapp.common.Constant
import com.magdy.cryptocurrencyapp.presentation.ui.coin_details.components.CoinDetailScreen
import com.magdy.cryptocurrencyapp.presentation.ui.coin_list.components.CoinListScreen
import com.magdy.cryptocurrencyapp.presentation.ui.theme.CryptOcurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptOcurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }

                        composable(
                            route = Screen.CoinDetailScreen.route +  "/{${Constant.COIN_ID}}"
                        ) {
                            CoinDetailScreen()
                        }

                    }
                }

            }

        }
    }
}
