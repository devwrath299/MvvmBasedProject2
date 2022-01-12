package com.example.mvvmbasedproject2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="quote")
data class Quotes(
    @PrimaryKey(autoGenerate = true)
    var  id:Int,
    var text:String,
    var author:String
)
