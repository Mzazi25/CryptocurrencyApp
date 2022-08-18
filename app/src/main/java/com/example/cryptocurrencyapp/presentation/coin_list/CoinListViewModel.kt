package com.example.cryptocurrencyapp.presentation.coin_list

import androidx.lifecycle.ViewModel
import com.example.cryptocurrencyapp.domain.use_cases.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private  val getCoinUseCase: GetCoinUseCase
): ViewModel(){

}