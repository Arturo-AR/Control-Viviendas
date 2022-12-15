package com.segared.controlviviendas.usecases.complaints.data.network

import com.segared.controlviviendas.core.models.DefaultServerResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface ComplaintsClient {

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun uploadComplain(
        @Query("opc") opc: Int,
        @Field("descripcion") complain: String,
        @Field("idUsuario") userId: Int,
        @Field("anonimo") anonymous: Int,

    ): Response<DefaultServerResponse>
}