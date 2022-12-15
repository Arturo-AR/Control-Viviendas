package com.segared.controlviviendas.usecases.myvehicles.data.network

import com.segared.controlviviendas.core.models.DefaultServerResponse
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.MyVehiclesResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface MyVehiclesClient {
    @FormUrlEncoded
    @POST("ws.php")
    suspend fun getPVehicles(
        @Query("opc") opc: Int,
        @Field("usuario") user: String
    ): Response<MyVehiclesResponse>

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun deleteVehicle(
        @Query("opc") opc: Int,
        @Field("idVehiculo") vehicleId: Int
    ): Response<DefaultServerResponse>

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun updateVehicles(
        @Query("opc") opc: Int,
        @Field("idVehiculo") vehicleId: Int,
        @Field("marca") vehicleBrand: String,
        @Field("placas") vehiclePlate: String,
        @Field("modelo") vehicleModel: String,
        @Field("color") vehicleColor: String,
        @Field("anio") vehicleYear: String
    ): Response<DefaultServerResponse>

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun addVehicle(
        @Query("opc") opc: Int,
        @Field("marcaVehiculo") vehicleBrand: String,
        @Field("modeloVehiculo") vehicleModel: String,
        @Field("placasVehiculo") vehiclePlate: String,
        @Field("colorVehiculo") vehicleColor: String,
        @Field("anioVehiculo") vehicleYear: String,
        @Field("idUsuario") userId: Int
    ): Response<DefaultServerResponse>
}