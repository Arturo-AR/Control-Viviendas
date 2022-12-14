package com.segared.controlviviendas.usecases.mypets.data.network

import com.segared.controlviviendas.core.models.DefaultServerResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.MyPetsResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.PetsTypesResponse
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
    ): Response<DefaultServerResponse>

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun updatePet(
        @Query("opc") opc: Int,
        @Field("idMascota") petId: Int,
        @Field("nombre") petName: String,
        @Field("raza") petBreed: String,
        @Field("color") petColor: String,
        @Field("tipoMascota") petTypeId: Int
    ): Response<DefaultServerResponse>

    @POST("ws.php")
    suspend fun getPetTypes(
        @Query("opc") opc: Int,
    ): Response<PetsTypesResponse>

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun addPet(
        @Query("opc") opc: Int,
        @Field("idTipoMascota") petTypeId: Int,
        @Field("nombreMascota") petName: String,
        @Field("razaMascota") petBreed: String,
        @Field("colorMascota") petColor: String,
        @Field("idUsuario") userId: Int
    ): Response<DefaultServerResponse>
}