package com.example.mvvmbasedproject2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface QuoteDao {

    @Query("SELECT * from quote")
    @JvmSuppressWildcards
    fun getQuotes():LiveData<List<Quotes>>

    @Insert
    suspend fun insertQuote(quotes: Quotes):Unit
}