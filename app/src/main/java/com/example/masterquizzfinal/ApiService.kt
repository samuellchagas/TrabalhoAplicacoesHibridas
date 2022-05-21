package com.example.masterquizzfinal

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @POST("api/Autenticacao/login")
    suspend fun getValidation(@Body login: Login): Response<RetornoApi>

    @GET("api/Questoes")
    suspend fun getQuestions(@Header("Authorization") token: String): Response<List<Quest>>

    @GET("api/Respostas/{idquestao}")
    suspend fun getAnswerById(
        @Header("Authorization") token: String,
        @Path("idquestao") id: Int
    ): Response<List<Answer>>

    companion object {
        fun getEndPointInstance(url: String): ApiService {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
        }
    }

}



