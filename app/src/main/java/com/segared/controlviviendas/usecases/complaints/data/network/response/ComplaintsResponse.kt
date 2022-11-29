package com.segared.controlviviendas.usecases.complaints.data.network.response

import com.google.gson.annotations.SerializedName

data class ComplaintsResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: String?
)
