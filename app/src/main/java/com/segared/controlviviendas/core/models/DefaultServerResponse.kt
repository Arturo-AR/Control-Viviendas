package com.segared.controlviviendas.core.models

import com.google.gson.annotations.SerializedName

data class DefaultServerResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: String?
)
