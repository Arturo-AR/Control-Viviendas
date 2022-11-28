package com.segared.controlviviendas.usecases.mypets.data.network.response

import com.google.gson.annotations.SerializedName

data class MyPetsResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: List<Pet>
)

data class Pet(
    @SerializedName("Nombre") val petName: String,
    @SerializedName("Raza") val breed: String,
    @SerializedName("Color") val color: String,
    @SerializedName("Tipo") val type: String
)