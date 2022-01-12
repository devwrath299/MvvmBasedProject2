package com.example.mvvmbasedproject2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(var quoteRepository: QuoteRepository):ViewModel() {
    fun getquotes() :LiveData<List<Quotes>>{
     return  quoteRepository.getQuotes()
    }


    fun insert(quote:Quotes)
    {
        viewModelScope.launch(Dispatchers.IO){
            quoteRepository.insert(quote)
        }
    }
}