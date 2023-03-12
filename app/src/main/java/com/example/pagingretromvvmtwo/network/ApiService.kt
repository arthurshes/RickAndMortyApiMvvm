package com.example.pagingretromvvmtwo.network

import androidx.lifecycle.LiveData
import com.example.pagingretromvvmtwo.model.RickAndMortyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
     fun getPerson(@Query("page")page:Int):Call<RickAndMortyData>
}