package com.example.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrencyapp.presentation.coin_detail.CoinDetailScreen
import com.example.cryptocurrencyapp.presentation.coin_detail.CoinDetailViewModel
import com.example.cryptocurrencyapp.presentation.coin_list.CoinListScreen
import com.example.cryptocurrencyapp.presentation.coin_list.CoinListViewModel
import com.example.cryptocurrencyapp.presentation.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val listViewModel: CoinListViewModel by viewModels()
                    val detailViewModel: CoinDetailViewModel by viewModels()
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ){
                        composable(route = Screen.CoinListScreen.route){
                            CoinListScreen( navController = navController, viewModel = listViewModel)
                        }
                        composable(route = Screen.CoinDetailScreen.route +"/{coinId}"){
                            CoinDetailScreen(viewModel = detailViewModel)
                        }
                    }
                }
                }
            }
        }
    }
