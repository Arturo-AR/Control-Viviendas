package com.segared.controlviviendas.usecases.signup.data.network

import com.segared.controlviviendas.core.models.DefaultServerResponse
import javax.inject.Inject

class SignupService @Inject constructor(private val signupClient: SignupClient) {
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
    ): DefaultServerResponse {
        val response = signupClient.signup(
            opc = 1,
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
        return if (response.body() == null) {
            throw Exception("Error")
        } else {
            response.body()!!
        }
    }
}