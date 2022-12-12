package com.segared.controlviviendas.usecases.mypets.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.usecases.mypets.data.network.response.Pet
import com.segared.controlviviendas.usecases.mypets.domain.AddPetUseCase
import com.segared.controlviviendas.usecases.mypets.domain.DeletePetUseCase
import com.segared.controlviviendas.usecases.mypets.domain.GetPetsListUseCase
import com.segared.controlviviendas.usecases.user.usecases.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPetsViewModel @Inject constructor(
    private val getPetUseCase: GetPetsListUseCase,
    private val addPetUseCase: AddPetUseCase,
    private val deletePetUseCase: DeletePetUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _userPetsList = MutableLiveData<List<Pet>>()
    val userPetsList: LiveData<List<Pet>> = _userPetsList

    private val _petTypeId = MutableLiveData<Int>()
    val petTypeId: LiveData<Int> = _petTypeId

    private val _petName = MutableLiveData<String>()
    val petName: LiveData<String> = _petName

    private val _petBreed = MutableLiveData<String>()
    val petBreed: LiveData<String> = _petBreed

    private val _petColor = MutableLiveData<String>()
    val petColor: LiveData<String> = _petColor

    private val _showAddPet = MutableLiveData<Boolean>()
    val showAddPet: LiveData<Boolean> = _showAddPet

    init {
        getPet()
    }

    private fun getPet() {
        viewModelScope.launch {
            val user = getUserUseCase.invoke()
            _userPetsList.value = getPetUseCase.invoke(user.user)
        }
    }

    fun deletePet(petId: Int) {
        viewModelScope.launch {
            if (deletePetUseCase.invoke(petId)) {
                Log.d("viewModel", "true")
                getPet()
            }
            Log.d("viewModel", "entro, despues")
        }
    }

    fun showAddPet() {
        _showAddPet.value = true
    }

    fun hideAddPet() {
        _showAddPet.value = false
    }

    fun onFormChange(petName: String, petBreed: String, petColor: String, petTypeId: Int) {
        _petName.value = petName
        _petBreed.value = petBreed
        _petColor.value = petColor
        _petTypeId.value = petTypeId
    }

    fun addPet(onError: () -> Unit) {
        viewModelScope.launch {
            if (addPetUseCase.invoke(
                    _petTypeId.value ?: 1,
                    _petName.value ?: "",
                    _petBreed.value ?: "",
                    _petColor.value ?: "",
                    1
                )
            ) {
                getPet()
                hideAddPet()
            } else {
                onError()
            }
        }
    }

}