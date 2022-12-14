package com.segared.controlviviendas.usecases.mypets.domain

import com.segared.controlviviendas.usecases.mypets.data.MyPetsRepository
import com.segared.controlviviendas.usecases.mypets.data.network.response.PetType
import javax.inject.Inject

class GetPetTypesUseCase @Inject constructor(private val repository: MyPetsRepository) {
    suspend operator fun invoke(): List<PetType> {
        return repository.getPetTypes().responseObject
    }
}