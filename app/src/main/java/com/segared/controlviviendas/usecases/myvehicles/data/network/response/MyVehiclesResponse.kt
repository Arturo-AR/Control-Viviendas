package com.segared.controlviviendas.usecases.myvehicles.data.network.response

import com.google.gson.annotations.SerializedName

data class MyVehiclesResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: List<Vehicle>
)

data class Vehicle(
    @SerializedName("Marca") val vehicleBrand: String,
    @SerializedName("Modelo") val vehicleModel: String,
    @SerializedName("Color") val vehicleColor: String,
    @SerializedName("Anio") val vehicleYear: String
)
