package com.segared.controlviviendas.usecases.user.usecases

import com.segared.controlviviendas.core.models.Session
import com.segared.controlviviendas.usecases.user.UserInstanceRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserInstanceRepository) {
    suspend operator fun invoke(): Session {
        return repository.getSession()
    }
}