package com.example.cryptocurrencyapp.presentation

sealed class Screen(val route: String){
    object CoinListScreen:Screen("coin_list_screen")
    object CoinDetailScreen:Screen("coin_detail_screen/{coinId}"){
        fun passHeroId(coinId:Int): String{
            return "detail_screen/$coinId"
        }
    }
}
