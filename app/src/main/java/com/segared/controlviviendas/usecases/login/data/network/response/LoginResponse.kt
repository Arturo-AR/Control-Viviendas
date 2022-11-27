package com.segared.controlviviendas.usecases.login.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: LoginObject?
)

data class LoginObject(
    @SerializedName("usuario") val user: String,
    @SerializedName("idUsuario") val userId: Int,
    @SerializedName("nombreUsuario") val userName: String,
    @SerializedName("apellidoUsuario") val userLastName: String,
    @SerializedName("rol") val rol: Int,
)