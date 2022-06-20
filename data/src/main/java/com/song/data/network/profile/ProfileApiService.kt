package com.song.data.network.profile

import com.song.model.profile.response_models.GetGomoUserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.QueryMap

interface ProfileApiService {

    @GET("xxx/xxx")
    suspend fun getGomoUser(@HeaderMap headerMap: Map<String, String>, @QueryMap queryMap: Map<String, String>): Response<GetGomoUserResponse>

}