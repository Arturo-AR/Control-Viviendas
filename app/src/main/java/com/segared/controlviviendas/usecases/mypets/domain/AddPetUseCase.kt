package com.segared.controlviviendas.usecases.mypets.domain

import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.mypets.data.MyPetsRepository
import javax.inject.Inject

class AddPetUseCase @Inject constructor(private val repository: MyPetsRepository) {
    suspend operator fun invoke(
        petTypeId: Int,
        petName: String,
        petBreed: String,
        petColor: String,
        userId: Int
    ): Boolean {

        return repository.addPet(
            petTypeId,
            petName,
            petBreed,
            petColor,
            userId
        ).responseCode == Constants.SUCCESS_CODE
    }
}