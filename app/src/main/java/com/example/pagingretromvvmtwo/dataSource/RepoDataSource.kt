package com.example.pagingretromvvmtwo.dataSource

import androidx.paging.PageKeyedDataSource
import com.example.pagingretromvvmtwo.model.CharacterData
import com.example.pagingretromvvmtwo.model.RickAndMortyData
import com.example.pagingretromvvmtwo.network.ApiService
import com.example.pagingretromvvmtwo.network.RetrofitNet
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RepoDataSource:PageKeyedDataSource<Int,CharacterData>() {

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {
        val retro=RetrofitNet.getRetrofit().create(ApiService::class.java)
        val call =retro.getPerson(params.key)
        call.enqueue(object :retrofit2.Callback<RickAndMortyData>{

            override fun onResponse(
                call: Call<RickAndMortyData>,
                response: Response<RickAndMortyData>
            ) {
                if (response.isSuccessful) {
                    callback.onResult(response?.body()?.results!!,  params.key+1)
                }
            }

            override fun onFailure(call: Call<RickAndMortyData>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {

    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CharacterData>
    ) {
val retro=RetrofitNet.getRetrofit().create(ApiService::class.java)
        val call =retro.getPerson(1)
        call.enqueue(object :retrofit2.Callback<RickAndMortyData>{

            override fun onResponse(
                call: Call<RickAndMortyData>,
                response: Response<RickAndMortyData>
            ) {
                if (response.isSuccessful) {
                    callback.onResult(response?.body()?.results!!, null, 2)
                }
            }

            override fun onFailure(call: Call<RickAndMortyData>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}