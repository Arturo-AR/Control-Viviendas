package com.segared.controlviviendas.usecases.advertisements.data.network.response

import com.google.gson.annotations.SerializedName

data class AdvertisementsResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: List<AdvertisementsBody>?
)

data class AdvertisementsBody(
    @SerializedName("Titulo") val advertisementTitle: String,
    @SerializedName("Contenido") val advertisementBody: String,
    @SerializedName("Fecha") val date: String,
    @SerializedName("Categoria") val category: String
)
