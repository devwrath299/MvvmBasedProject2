package com.example.mvvmbasedproject2

import androidx.lifecycle.LiveData

class QuoteRepository(var quoteDao:QuoteDao) {

    fun getQuotes():LiveData<List<Quotes>>{
        return quoteDao.getQuotes()
    }

    suspend fun insert(quotes: Quotes)
    {
        quoteDao.insertQuote(quotes)
    }
}