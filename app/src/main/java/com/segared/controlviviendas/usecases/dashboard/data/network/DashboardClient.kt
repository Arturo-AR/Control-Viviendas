package com.segared.controlviviendas.usecases.dashboard.data.network

import com.segared.controlviviendas.usecases.dashboard.data.network.response.PermissionsResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface DashboardClient {
    @FormUrlEncoded
    @POST("ws.php")
    suspend fun getPermissionsList(
        @Query("opc") opc: Int,
        @Field("idRol") userRolId: Int
    ): Response<PermissionsResponse>
}