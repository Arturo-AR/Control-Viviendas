package com.segared.controlviviendas.usecases.login.data.network

import com.segared.controlviviendas.usecases.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginClient {
    @FormUrlEncoded
    @POST("ws.php")
    suspend fun login(
        @Query("opc") opc: Int,
        @Field("usuario") user: String,
        @Field("password") password: String
    ): Response<LoginResponse>
}