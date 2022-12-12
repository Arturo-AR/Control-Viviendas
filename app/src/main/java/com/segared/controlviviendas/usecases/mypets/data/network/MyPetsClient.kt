package com.segared.controlviviendas.usecases.mypets.data.network

import com.segared.controlviviendas.usecases.mypets.data.network.response.AddPetsResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.DeletePetResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.MyPetsResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface MyPetsClient {

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun getPets(
        @Query("opc") opc: Int,
        @Field("usuario") user: String
    ): Response<MyPetsResponse>

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun deletePet(
        @Query("opc") opc: Int,
        @Field("idMascota") petId: Int
    ): Response<DeletePetResponse>

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun addPet(
        @Query("opc") opc: Int,
        @Field("idTipoMascota") petTypeId: Int,
        @Field("nombreMascota") petName: String,
        @Field("razaMascota") petBreed: String,
        @Field("colorMascota") petColor: String,
        @Field("idUsuario") userId: Int
    ): Response<AddPetsResponse>
}