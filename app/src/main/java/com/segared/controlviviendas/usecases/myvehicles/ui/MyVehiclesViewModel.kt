package com.segared.controlviviendas.usecases.myvehicles.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.Vehicle
import com.segared.controlviviendas.usecases.myvehicles.domain.AddVehicleUseCase
import com.segared.controlviviendas.usecases.myvehicles.domain.DeleteVehicleUseCase
import com.segared.controlviviendas.usecases.myvehicles.domain.GetVehiclesListUseCase
import com.segared.controlviviendas.usecases.myvehicles.domain.UpdateVehicleUseCase
import com.segared.controlviviendas.usecases.user.usecases.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyVehiclesViewModel @Inject constructor(
    private val getVehiclesUseCase: GetVehiclesListUseCase,
    private val addVehicleUseCase: AddVehicleUseCase,
    private val deleteVehicleUseCase: DeleteVehicleUseCase,
    private val updateVehicleUseCase: UpdateVehicleUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _userVehiclesList = MutableLiveData<List<Vehicle>>()
    val userVehiclesList: LiveData<List<Vehicle>> = _userVehiclesList

    private val _vehicleBrand = MutableLiveData<String>()
    val vehicleBrand: LiveData<String> = _vehicleBrand

    private val _vehiclePlate = MutableLiveData<String>()
    val vehiclePlate: LiveData<String> = _vehiclePlate

    private val _vehicleModel = MutableLiveData<String>()
    val vehicleModel: LiveData<String> = _vehicleModel

    private val _vehicleColor = MutableLiveData<String>()
    val vehicleColor: LiveData<String> = _vehicleColor

    private val _vehicleYear = MutableLiveData<String>()
    val vehicleYear: LiveData<String> = _vehicleYear

    private val _showAddVehicle = MutableLiveData<Boolean>()
    val showAddVehicle: LiveData<Boolean> = _showAddVehicle

    private val _vehicleId = MutableLiveData<Int>()

    init {
        getVehicles()
    }

    private fun getVehicles() {
        viewModelScope.launch {
            val user = getUserUseCase.invoke()
            _userVehiclesList.value = getVehiclesUseCase.invoke(user.user)
        }
    }

    fun showAddVehicle() {
        _showAddVehicle.value = true
    }

    fun hideAddVehicle() {
        _showAddVehicle.value = false
    }

    fun deleteVehicle() {
        viewModelScope.launch {
            if (deleteVehicleUseCase.invoke(_vehicleId.value ?: 0)) {
                getVehicles()
            }
        }
    }

    fun onFormChange(
        vehicleBrand: String,
        vehicleModel: String,
        vehicleYear: String,
        vehicleColor: String,
        vehiclePlate: String
    ) {
        _vehicleBrand.value = vehicleBrand
        _vehicleModel.value = vehicleModel
        _vehicleYear.value = vehicleYear
        _vehicleColor.value = vehicleColor
        _vehiclePlate.value = vehiclePlate
    }

    fun addVehicle(onError: () -> Unit) {
        viewModelScope.launch {
            val user = getUserUseCase.invoke()
            if (addVehicleUseCase.invoke(
                    _vehicleBrand.value ?: "",
                    _vehicleModel.value ?: "",
                    _vehiclePlate.value ?: "",
                    _vehicleColor.value ?: "",
                    _vehicleYear.value ?: "",
                    user.userId
                )
            ) {
                getVehicles()
                hideAddVehicle()
            } else {
                onError()
            }
        }
    }

    fun editVehicle(vehicleId: Int, index: Int) {
        _vehicleId.value = vehicleId
        _vehicleColor.value = _userVehiclesList.value?.get(index)?.vehicleColor
        _vehicleBrand.value = _userVehiclesList.value?.get(index)?.vehicleBrand
        _vehicleModel.value = _userVehiclesList.value?.get(index)?.vehicleModel
        _vehiclePlate.value = _userVehiclesList.value?.get(index)?.vehiclePlate
        _vehicleYear.value = _userVehiclesList.value?.get(index)?.vehicleYear
    }

    fun updateVehicle() {
        viewModelScope.launch {
            if (updateVehicleUseCase.invoke(
                    _vehicleId.value ?: 0,
                    _vehicleBrand.value ?: "",
                    _vehiclePlate.value ?: "",
                    _vehicleModel.value ?: "",
                    _vehicleColor.value ?: "",
                    _vehicleYear.value ?: ""
                )
            ) {
                getVehicles()
                hideAddVehicle()
            }
        }
    }

    fun cleanVehicle() {
        _vehicleBrand.value = ""
        _vehicleModel.value = ""
        _vehicleYear.value = ""
        _vehicleColor.value = ""
        _vehiclePlate.value = ""
    }
}