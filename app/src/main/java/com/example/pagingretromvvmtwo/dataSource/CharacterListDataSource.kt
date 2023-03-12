package com.example.pagingretromvvmtwo.dataSource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.pagingretromvvmtwo.model.CharacterData

class CharacterListDataSource():DataSource.Factory<Int,CharacterData>(){

    private var mutableLiveData:MutableLiveData<RepoDataSource>?=null

    init {
        mutableLiveData= MutableLiveData()

    }

    override fun create(): DataSource<Int, CharacterData> {
 val repo = RepoDataSource()
        mutableLiveData?.postValue(repo)
        return repo
    }


}