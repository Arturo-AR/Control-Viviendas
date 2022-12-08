package com.segared.controlviviendas.usecases.user.usecases

import com.segared.controlviviendas.usecases.user.UserInstanceRepository
import javax.inject.Inject

class SetUserUseCase @Inject constructor(private val repository: UserInstanceRepository) {
    suspend operator fun invoke(userId: Int, userRol: Int, userName: String) {
        repository.setSession(userId, userRol, userName)
    }
}