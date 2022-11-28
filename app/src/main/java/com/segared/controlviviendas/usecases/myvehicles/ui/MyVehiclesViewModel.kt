package com.segared.controlviviendas.usecases.myvehicles.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.Vehicle
import com.segared.controlviviendas.usecases.myvehicles.domain.AddVehicleUseCase
import com.segared.controlviviendas.usecases.myvehicles.domain.GetVehiclesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyVehiclesViewModel @Inject constructor(
    private val getVehiclesUseCase: GetVehiclesListUseCase,
    private val addVehicleUseCase: AddVehicleUseCase
) : ViewModel() {

    private val _userVehiclesList = MutableLiveData<List<Vehicle>>()
    val userVehiclesList: LiveData<List<Vehicle>> = _userVehiclesList

    private val _vehicleBrand = MutableLiveData<String>()
    val vehicleBrand: LiveData<String> = _vehicleBrand

    private val _vehicleModel = MutableLiveData<String>()
    val vehicleModel: LiveData<String> = _vehicleModel

    private val _vehicleColor = MutableLiveData<String>()
    val vehicleColor: LiveData<String> = _vehicleColor

    private val _vehicleYear = MutableLiveData<String>()
    val vehicleYear: LiveData<String> = _vehicleYear

    private val _showAddVehicle = MutableLiveData<Boolean>()
    val showAddVehicle: LiveData<Boolean> = _showAddVehicle

    init {
        getVehicles()
    }

    private fun getVehicles() {
        viewModelScope.launch {
            _userVehiclesList.value = getVehiclesUseCase.invoke(1)
        }
    }


    fun showAddVehicle() {
        _showAddVehicle.value = true
    }

    fun hideAddVehicle() {
        _showAddVehicle.value = false
    }

    fun onFormChange(
        vehicleBrand: String,
        vehicleModel: String,
        vehicleYear: String,
        vehicleColor: String,
    ) {
        _vehicleBrand.value = vehicleBrand
        _vehicleModel.value = vehicleModel
        _vehicleYear.value = vehicleYear
        _vehicleColor.value = vehicleColor
    }

    fun addVehicle(onError: () -> Unit) {
        viewModelScope.launch {
            if (addVehicleUseCase.invoke(
                    _vehicleBrand.value ?: "",
                    _vehicleModel.value ?: "",
                    _vehicleColor.value ?: "",
                    _vehicleYear.value ?: "",
                    1
                )
            ) {
                getVehicles()
                hideAddVehicle()
            } else {
                onError()
            }
        }
    }

}