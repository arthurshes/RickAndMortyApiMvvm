package com.example.pagingretromvvmtwo.view.recyclerAdapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingretromvvmtwo.DffUtil.ReyclerDiffUtil
import com.example.pagingretromvvmtwo.R
import com.example.pagingretromvvmtwo.model.CharacterData
import com.squareup.picasso.Picasso


class RecyclerAdapter:PagedListAdapter<CharacterData,RecyclerAdapter.MyViewHolder>(ReyclerDiffUtil()) {



    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val txtName:TextView=itemView.findViewById(R.id.textViewName)
        val txtSpec:TextView=itemView.findViewById(R.id.textViewSpecial)
        val imageAv:ImageView=itemView.findViewById(R.id.imageViewAvatar)
fun bind(characterData: CharacterData){
 Picasso.get().load(characterData.image).into(imageAv)
 txtName.text=characterData.name
 txtSpec.text=characterData.species
}
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
   return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }
}