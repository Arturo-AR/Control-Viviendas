package com.segared.controlviviendas.usecases.login.domain

import com.segared.controlviviendas.usecases.login.data.LoginRepository
import javax.inject.Inject

class SaveUserDataUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke() {

    }
}