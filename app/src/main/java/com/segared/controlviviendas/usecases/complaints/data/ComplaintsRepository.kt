package com.segared.controlviviendas.usecases.complaints.data

import com.segared.controlviviendas.core.models.DefaultServerResponse
import com.segared.controlviviendas.usecases.complaints.data.network.ComplaintsService
import javax.inject.Inject

class ComplaintsRepository @Inject constructor(
    private val api: ComplaintsService
) {
    suspend fun uploadComplain(
        complain: String,
        userId: Int,
        anonymous: Int,
    ): DefaultServerResponse {
        return api.uploadComplaint(complain, userId, anonymous)
    }
}