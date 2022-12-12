package com.segared.controlviviendas.usecases.mypets.data.network.response

import com.google.gson.annotations.SerializedName

data class MyPetsResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: List<Pet>
)

data class Pet(
    @SerializedName("idMascora") val petId: Int,
    @SerializedName("mascota") val petName: String,
    @SerializedName("raza") val breed: String,
    @SerializedName("color") val color: String,
    @SerializedName("tipo") val type: String
)