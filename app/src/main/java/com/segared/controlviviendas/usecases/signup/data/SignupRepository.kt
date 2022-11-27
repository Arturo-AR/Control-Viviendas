package com.segared.controlviviendas.usecases.signup.data

import com.segared.controlviviendas.usecases.signup.data.network.SignupService
import com.segared.controlviviendas.usecases.signup.data.network.response.SignupResponse
import javax.inject.Inject

class SignupRepository @Inject constructor(private val api: SignupService) {
    suspend fun signup(
        name: String,
        lastName: String,
        mothersLastName: String,
        street: String,
        number: String,
        phone: String,
        user: String,
        password: String,
        inePhoto: String,
        typeId: Int
    ): SignupResponse {
        return api.signup(
            name = name,
            lastName = lastName,
            mothersLastName = mothersLastName,
            street = street,
            number = number,
            phone = phone,
            inePhoto = inePhoto,
            user = user,
            password = password,
            typeId = typeId,
        )
    }
}