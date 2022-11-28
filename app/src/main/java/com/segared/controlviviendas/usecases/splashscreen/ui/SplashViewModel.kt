package com.segared.controlviviendas.usecases.splashscreen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.usecases.splashscreen.domain.CheckUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val checkUserData: CheckUserDataUseCase) :
    ViewModel() {

    private val _logged = MutableLiveData<Boolean>()
    val logged: LiveData<Boolean> = _logged

    init {
        viewModelScope.launch(Dispatchers.Main) {
            _logged.value = true
                //checkUserData.invoke()
        }
    }

}