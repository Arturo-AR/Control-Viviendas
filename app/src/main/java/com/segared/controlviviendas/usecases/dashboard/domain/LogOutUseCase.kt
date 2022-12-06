package com.segared.controlviviendas.usecases.dashboard.domain

import com.segared.controlviviendas.usecases.dashboard.data.DashboardRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(private val repository: DashboardRepository) {
    suspend operator fun invoke() {
        //repository.logOut()
    }
}