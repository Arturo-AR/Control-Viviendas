package com.segared.controlviviendas.usecases.mypets.domain

import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.mypets.data.MyPetsRepository
import javax.inject.Inject

class UpdatePetUseCase @Inject constructor(private val repository: MyPetsRepository) {
    suspend operator fun invoke(
        petId: Int,
        petName: String,
        petBreed: String,
        petColor: String,
        petTypeId: Int
    ): Boolean {
        return repository.updatePet(
            petId,
            petName,
            petBreed,
            petColor,
            petTypeId
        ).responseCode == Constants.SUCCESS_CODE
    }
}