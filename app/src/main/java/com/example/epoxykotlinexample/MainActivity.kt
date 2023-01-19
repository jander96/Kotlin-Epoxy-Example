package com.example.epoxykotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainEpoxyController = MainEpoxyController(list){
            doSomthing()
        }
        epoxyRecyclerView = binding.recyclerView
        epoxyRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        epoxyRecyclerView.setController(mainEpoxyController)

    }

    private fun doSomthing() {
        TODO("Not yet implemented")
    }
}