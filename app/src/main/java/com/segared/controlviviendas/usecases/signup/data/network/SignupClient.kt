package com.segared.controlviviendas.usecases.signup.data.network

import com.segared.controlviviendas.usecases.signup.data.network.response.SignupResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface SignupClient {
    @FormUrlEncoded
    @POST("ws.php")
    suspend fun signup(
        @Query("opc") opc: Int,
        @Field("nombre") name: String,
        @Field("apPat") lastName: String,
        @Field("apMat") mothersLastName: String,
        @Field("calle") street: String,
        @Field("numero") number: String,
        @Field("celular") phone: String,
        @Field("fotoIne") inePhoto: String,
        @Field("usuario") user: String,
        @Field("password") password: String,
        @Field("idTipo") typeId: Int,
    ): Response<SignupResponse>
}