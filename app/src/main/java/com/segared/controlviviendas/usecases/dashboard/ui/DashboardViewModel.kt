package com.segared.controlviviendas.usecases.dashboard.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.dashboard.domain.GetPermissionsUseCase
import com.segared.controlviviendas.usecases.user.usecases.GetUserUseCase
import com.segared.controlviviendas.usecases.user.usecases.LogOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getPermissionsUseCase: GetPermissionsUseCase,
    private val logOutUseCase: LogOutUseCase,
    private val getUserUseCase: GetUserUseCase
) :
    ViewModel() {
    private val _permissions = MutableLiveData<List<String>>()
    val permissions: LiveData<List<String>> = _permissions

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    init {
        getPermissions()
        setUserName()
    }

    private fun getPermissions() {
        viewModelScope.launch {
            try {
                val user = getUserUseCase.invoke()
                val response = getPermissionsUseCase.invoke(user.userRol)
                if (response.responseCode == Constants.SUCCESS_CODE) {
                    _permissions.value = response.responseObject
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }

    fun logOut() {
        viewModelScope.launch {
            logOutUseCase.invoke()
        }
    }

    private fun setUserName() {
        viewModelScope.launch {
            _userName.value = getUserUseCase.invoke().userName
        }
    }
}