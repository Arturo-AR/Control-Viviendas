package com.segared.controlviviendas.usecases.complaints.data

import com.segared.controlviviendas.usecases.complaints.data.network.ComplaintsService
import com.segared.controlviviendas.usecases.complaints.data.network.response.ComplaintsResponse
import javax.inject.Inject

class ComplaintsRepository @Inject constructor(
    private val api: ComplaintsService
) {
    suspend fun uploadComplain(
        complain: String,
        userId: Int,
        anonymous: Int,
    ): ComplaintsResponse {
        return api.uploadComplaint(complain, userId, anonymous)
    }
}