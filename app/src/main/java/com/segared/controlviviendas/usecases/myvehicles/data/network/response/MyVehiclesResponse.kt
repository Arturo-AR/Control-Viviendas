package com.segared.controlviviendas.usecases.myvehicles.data.network.response

import com.google.gson.annotations.SerializedName

data class MyVehiclesResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: List<Vehicle>
)

data class Vehicle(
    @SerializedName("idVehiculo") val vehicleId: Int,
    @SerializedName("marca") val vehicleBrand: String,
    @SerializedName("modelo") val vehicleModel: String,
    @SerializedName("placas") val vehiclePlate: String,
    @SerializedName("color") val vehicleColor: String,
    @SerializedName("anio") val vehicleYear: String
)
