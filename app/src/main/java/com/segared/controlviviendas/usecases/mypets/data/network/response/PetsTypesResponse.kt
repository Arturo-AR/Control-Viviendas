package com.segared.controlviviendas.usecases.mypets.data.network.response

import com.google.gson.annotations.SerializedName

data class PetsTypesResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: List<PetType>
)

data class PetType(
    @SerializedName("idTipoMascota") val petTypeId: Int,
    @SerializedName("Descripcion") val descriptionType: String
)
