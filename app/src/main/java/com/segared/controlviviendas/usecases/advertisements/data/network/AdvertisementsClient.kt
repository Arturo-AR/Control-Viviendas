package com.segared.controlviviendas.usecases.advertisements.data.network

import com.segared.controlviviendas.usecases.advertisements.data.network.response.AdvertisementsResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface AdvertisementsClient {
    @POST("ws.php")
    suspend fun getAdvertisements(
        @Query("opc") opc: Int
    ): Response<AdvertisementsResponse>
}