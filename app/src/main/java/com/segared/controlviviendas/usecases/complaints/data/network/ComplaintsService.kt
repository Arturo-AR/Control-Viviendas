package com.segared.controlviviendas.usecases.complaints.data.network

import com.segared.controlviviendas.core.models.DefaultServerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ComplaintsService @Inject constructor(private val complaintsClient: ComplaintsClient) {

    suspend fun uploadComplaint(
        complain: String,
        userId: Int,
        anonymous: Int,
    ): DefaultServerResponse {
        return withContext(Dispatchers.IO) {
            val response = complaintsClient.uploadComplain(14, complain, userId, anonymous)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }
}