package com.segared.controlviviendas.usecases.user.usecases

import com.segared.controlviviendas.usecases.user.UserInstanceRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(private val repository: UserInstanceRepository) {
    suspend operator fun invoke() {
        repository.logOut()
    }
}