package com.example.pagingretromvvmtwo.DffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.pagingretromvvmtwo.model.CharacterData

class ReyclerDiffUtil:DiffUtil.ItemCallback<CharacterData>() {

    override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
  return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
       return oldItem.name == newItem.name && oldItem.species == newItem.species
    }

}