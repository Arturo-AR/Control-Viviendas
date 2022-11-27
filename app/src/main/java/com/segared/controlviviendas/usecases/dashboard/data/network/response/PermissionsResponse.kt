package com.segared.controlviviendas.usecases.dashboard.data.network.response

import com.google.gson.annotations.SerializedName

data class PermissionsResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: List<String>
)