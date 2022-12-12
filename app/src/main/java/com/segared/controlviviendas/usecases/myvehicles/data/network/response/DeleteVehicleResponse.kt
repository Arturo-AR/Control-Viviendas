package com.segared.controlviviendas.usecases.myvehicles.data.network.response

import com.google.gson.annotations.SerializedName

data class DeleteVehicleResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: String?
)
