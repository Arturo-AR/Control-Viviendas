package com.segared.controlviviendas.usecases.mypets.domain

import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.mypets.data.MyPetsRepository
import javax.inject.Inject

class DeletePetUseCase @Inject constructor(private val repository: MyPetsRepository) {
    suspend operator fun invoke(petId: Int): Boolean {
        return repository.deletePet(petId).responseCode == Constants.SUCCESS_CODE
    }
}