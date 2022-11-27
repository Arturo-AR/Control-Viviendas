package com.segared.controlviviendas.usecases.advertisements.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.advertisements.data.network.response.AdvertisementsBody
import com.segared.controlviviendas.usecases.advertisements.domain.GetAdvertisementsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdvertisementsViewModel @Inject constructor(private val getAdvertisementsUseCase: GetAdvertisementsUseCase) :
    ViewModel() {
    private val _advertisements = MutableLiveData<List<AdvertisementsBody>>()
    val advertisements: LiveData<List<AdvertisementsBody>> = _advertisements

    init {
        getAdvertisements()
    }

    private fun getAdvertisements() {
        viewModelScope.launch {
            try {
                val response = getAdvertisementsUseCase.invoke()
                if (response.responseCode == Constants.SUCCESS_CODE) {
                    _advertisements.value = response.responseObject
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}