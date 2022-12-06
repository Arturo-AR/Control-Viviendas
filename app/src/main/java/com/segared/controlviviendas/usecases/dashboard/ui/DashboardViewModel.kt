package com.segared.controlviviendas.usecases.dashboard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.dashboard.domain.GetPermissionsUseCase
import com.segared.controlviviendas.usecases.dashboard.domain.GetUserRolUseCase
import com.segared.controlviviendas.usecases.dashboard.domain.LogOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getPermissionsUseCase: GetPermissionsUseCase,
    private val logOutUseCase: LogOutUseCase,
    private val getUserRolUseCase: GetUserRolUseCase
) :
    ViewModel() {
    private val _permissions = MutableLiveData<List<String>>()
    val permissions: LiveData<List<String>> = _permissions

    init {
        getPermissions()
    }

    private fun getPermissions() {
        viewModelScope.launch {
            try {
                val rol = getUserRolUseCase.invoke()
                val response = getPermissionsUseCase.invoke(rol)
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
}