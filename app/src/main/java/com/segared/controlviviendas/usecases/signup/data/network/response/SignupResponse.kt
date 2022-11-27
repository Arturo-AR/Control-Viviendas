package com.segared.controlviviendas.usecases.signup.data.network.response

import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: String?
)