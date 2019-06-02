package br.com.killkinto.mvvm_breeds.remote

import retrofit2.Call
import retrofit2.http.GET

interface DogCeoApi {
    @GET("breeds/list")
    fun listBreeds(): Call<DogCeoResponse>
}