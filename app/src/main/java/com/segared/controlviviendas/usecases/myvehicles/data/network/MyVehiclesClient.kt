package com.segared.controlviviendas.usecases.myvehicles.data.network

import com.segared.controlviviendas.usecases.myvehicles.data.network.response.AddVehiclesResponse
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
        @Field("idUsuario") user: Int
    ): Response<MyVehiclesResponse>

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun addVehicle(
        @Query("opc") opc: Int,
        @Field("marcaVehiculo") vehicleBrand: String,
        @Field("modeloVehiculo") vehicleModel: String,
        @Field("colorVehiculo") vehicleColor: String,
        @Field("anioVehiculo") vehicleYear: String,
        @Field("idUsuario") userId: Int
    ): Response<AddVehiclesResponse>
}