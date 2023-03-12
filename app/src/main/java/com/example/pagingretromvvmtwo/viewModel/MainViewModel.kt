package com.example.pagingretromvvmtwo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import com.example.pagingretromvvmtwo.dataSource.CharacterListDataSource
import com.example.pagingretromvvmtwo.model.CharacterData
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MainViewModel:ViewModel() {
    private var characterList:LiveData<PagedList<CharacterData>>?=null


    init {
        initPaging()

    }

    private fun initPaging() {
        val factory=CharacterListDataSource()
       val con= PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(30)
            .build()

      val executar:Executor = Executors.newFixedThreadPool(5)

   characterList =  LivePagedListBuilder<Int,CharacterData>(factory,con)
            .setFetchExecutor(executar)
            .build()
    }


    fun getRecyclerList():LiveData<PagedList<CharacterData>>?{
        return characterList
    }
}