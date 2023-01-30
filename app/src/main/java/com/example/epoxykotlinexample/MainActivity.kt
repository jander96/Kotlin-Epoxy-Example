package com.example.epoxykotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.epoxykotlinexample.crontroller.MainEpoxyController
import com.example.epoxykotlinexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var epoxyRecyclerView: EpoxyRecyclerView
    private lateinit var mainEpoxyController: MainEpoxyController
    private val list = listOf("Cuba","Venezuela ", "Alemania","Estados Unidos","Brazil")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity","onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainEpoxyController = MainEpoxyController{
            doSomthing(it)
        }
        mainEpoxyController.titles = list
        epoxyRecyclerView = binding.recyclerView
        epoxyRecyclerView.setController(mainEpoxyController)

    }

    private fun doSomthing(pais :String) {
        Toast.makeText(this,"Se esta haciendo click en $pais",Toast.LENGTH_SHORT).show()
    }
}