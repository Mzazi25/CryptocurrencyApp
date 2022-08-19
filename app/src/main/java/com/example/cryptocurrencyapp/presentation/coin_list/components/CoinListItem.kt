package com.example.cryptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.cryptocurrencyapp.domain.models.Coin

@Composable
fun CoinListItem(
    coin:Coin,
    onItemClick:(Coin) ->Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){

    }
}