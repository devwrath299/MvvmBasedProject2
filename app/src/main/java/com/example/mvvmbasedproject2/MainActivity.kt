package com.example.mvvmbasedproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasedproject2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        var quoteDao=QuoteDatabase.getDatabase(applicationContext).quoteDao()
        var repository=QuoteRepository(quoteDao)
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.getquotes().observe(this,{
            binding.quotes=it.toString()
        })
        binding.btnaddqiote.setOnClickListener {
            var quotes=Quotes(0,"This is good","fdkfkdfm")
            mainViewModel.insert(quotes)
        }
    }
}