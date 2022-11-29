package com.segared.controlviviendas.usecases.complaints.domain

import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.complaints.data.ComplaintsRepository
import javax.inject.Inject

class UploadComplaintUseCase @Inject constructor(private val repository: ComplaintsRepository) {
    suspend operator fun invoke(
        complain: String,
        userId: Int,
        anonymous: Int
    ): Boolean {
        return repository.uploadComplain(
            complain,
            userId,
            anonymous
        ).responseCode == Constants.SUCCESS_CODE
    }
}