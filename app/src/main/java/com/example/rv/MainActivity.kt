package com.example.rv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvExample.adapter = ExampleRecyclerView(getData())
        binding.rvExample.layoutManager = LinearLayoutManager(this)


    }

    private fun getData(): List<ViewData> = listOf(
        FirstData(text = "Pararam"),
        SecondData(text = "Lolololo"),
        SecondData(text = "kkkkk", switched = true)
    )
}