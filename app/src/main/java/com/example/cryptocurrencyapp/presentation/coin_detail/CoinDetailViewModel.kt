package com.example.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Constants
import com.example.cryptocurrencyapp.common.Constants.PARAM_COIN_ID
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.use_cases.get_coin.GetCoinUseCase
import com.example.cryptocurrencyapp.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private  val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    private val currentCoinId:Int? = null

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoin(PARAM_COIN_ID)
        }
    }

    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success ->{
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = CoinDetailState(error = result.message?:" An unexpected Error Occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}