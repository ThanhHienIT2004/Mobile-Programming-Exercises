package com.example.baitaplaptrinhdidong.screens.week4.w4_2.api

import com.example.baitaplaptrinhdidong.screens.week4.w4_2.model.TaskResponse
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.model.TaskResponse2
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Path

interface ApiService{
    @GET("researchUTH/tasks")
    suspend fun getTasks(): Response<TaskResponse>

    @GET("researchUTH/task/{id}")
    suspend fun getTaskById(@Path("id") id : Int) : Response<TaskResponse2>
}