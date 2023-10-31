package com.example.smarthomeproject

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("auth")
    suspend fun login(@Query("username") username:String,@Query("password") password:String): Response<ResponseBody>
}