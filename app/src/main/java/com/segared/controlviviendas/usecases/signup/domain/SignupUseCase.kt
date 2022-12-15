package com.segared.controlviviendas.usecases.signup.domain

import android.graphics.Bitmap
import com.segared.controlviviendas.core.models.DefaultServerResponse
import com.segared.controlviviendas.core.util.toBase64String
import com.segared.controlviviendas.usecases.signup.data.SignupRepository
import javax.inject.Inject

class SignupUseCase @Inject constructor(private val repository: SignupRepository) {
    suspend operator fun invoke(
        name: String,
        lastName: String,
        mothersLastName: String,
        street: String,
        number: String,
        phone: String,
        user: String,
        password: String,
        inePhoto: Bitmap?,
        typeId: Int
    ): DefaultServerResponse {
        return repository.signup(
            name = name,
            lastName = lastName,
            mothersLastName = mothersLastName,
            street = street,
            number = number,
            phone = phone,
            inePhoto = inePhoto?.toBase64String() ?: "",
            user = user,
            password = password,
            typeId = typeId
        )
    }
}