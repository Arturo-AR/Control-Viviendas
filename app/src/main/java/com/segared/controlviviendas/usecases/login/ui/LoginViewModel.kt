package com.segared.controlviviendas.usecases.login.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.core.util.Constants.SUCCESS_CODE
import com.segared.controlviviendas.usecases.login.domain.LoginUseCase
import com.segared.controlviviendas.usecases.user.usecases.SetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val setUserUseCase: SetUserUseCase
) : ViewModel() {
    private val _user = MutableLiveData<String>()
    val user: LiveData<String> = _user

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    fun onLoginChange(user: String, password: String) {
        _user.value = user
        _password.value = password
        _isLoginEnable.value = enableLogin(user, password)
    }

    fun login(
        user: String,
        password: String,
        onSuccess: () -> Unit,
        onError: () -> Unit,
        unValidate: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = loginUseCase.invoke(user, password)
                if (response.responseCode == SUCCESS_CODE) {
                    if (response.responseMessage == "Aun no verificada") {
                        unValidate()
                    } else {
                        if (response.responseObject != null) {
                            saveUser(
                                userId = response.responseObject.userId,
                                userRol = response.responseObject.rol,
                                userName = response.responseObject.userName,
                                user = response.responseObject.user
                            )
                        }
                        onSuccess()
                    }
                } else {
                    onError()
                }
            } catch (ex: Exception) {
                Log.d("Error Login", "Error at login: ${ex.message}")
            }
        }
    }

    private fun enableLogin(user: String, password: String) =
        user.isNotEmpty() && password.isNotEmpty()

    private suspend fun saveUser(userId: Int, userRol: Int, userName: String, user: String) {
        viewModelScope.launch {
            setUserUseCase.invoke(userId, userRol, userName, user)
        }.join()
    }
}