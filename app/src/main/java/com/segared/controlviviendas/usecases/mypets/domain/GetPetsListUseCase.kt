package com.segared.controlviviendas.usecases.mypets.domain

import com.segared.controlviviendas.usecases.mypets.data.MyPetsRepository
import com.segared.controlviviendas.usecases.mypets.data.network.response.Pet
import javax.inject.Inject

class GetPetsListUseCase @Inject constructor(private val repository: MyPetsRepository) {
    suspend operator fun invoke(user: Int): List<Pet> {
        return repository.getPets(user).responseObject
    }
}