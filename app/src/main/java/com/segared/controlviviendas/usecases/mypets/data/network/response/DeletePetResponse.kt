package com.segared.controlviviendas.usecases.mypets.data.network.response

import com.google.gson.annotations.SerializedName

data class DeletePetResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: String?
)
