package com.example.pagingretromvvmtwo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.pagingretromvvmtwo.databinding.ActivityMainBinding
import com.example.pagingretromvvmtwo.view.recyclerAdapter.RecyclerAdapter
import com.example.pagingretromvvmtwo.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
private lateinit var recyclerAdapter:RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

initRecyclerView()
initViewModel()
    }

    private fun initRecyclerView() {
        recyclerAdapter= RecyclerAdapter()
val deco=DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)
        binding.recycler.apply {
            addItemDecoration(deco)
            setHasFixedSize(true)
adapter=recyclerAdapter
        }
    }
    private fun initViewModel(){
        val viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getRecyclerList()?.observe(this, Observer {
            if (it !=null){
                recyclerAdapter.submitList(it)
            }else{
                Toast.makeText(applicationContext,"Error null data",Toast.LENGTH_LONG).show()
            }
        })
    }
}