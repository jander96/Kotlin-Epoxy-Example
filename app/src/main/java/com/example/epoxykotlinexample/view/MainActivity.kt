package com.example.epoxykotlinexample.view

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.EpoxyTouchHelper
import com.example.epoxykotlinexample.controller.MainEpoxyController
import com.example.epoxykotlinexample.databinding.ActivityMainBinding
import com.example.epoxykotlinexample.models.DescriptionModel
import com.example.epoxykotlinexample.sources.DataSources
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainEpoxyController: MainEpoxyController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainEpoxyController = MainEpoxyController {
            doSomething(it)
        }
        // setting controller
        with(mainEpoxyController){
            personages = DataSources(this@MainActivity).listOfPersonages// pass personages list
        }
        // setting EpoxyRecyclerView
        with(binding.recyclerView){
            this.setController(mainEpoxyController)
                this.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

        // setting swipe recycler`s function
        EpoxyTouchHelper.initSwiping(binding.recyclerView)
            .right()
            .withTarget(DescriptionModel::class.java)
            .andCallbacks(object : EpoxyTouchHelper.SwipeCallbacks<DescriptionModel>() {
                override fun onSwipeCompleted(
                    model: DescriptionModel?,
                    itemView: View?,
                    position: Int,
                    direction: Int
                ) {
                    // Any other function like delete from database or add to favorite
                    Snackbar.make(binding.root, "Any Function", Snackbar.LENGTH_SHORT).apply {
                        this.setAction("undo action") {

                        }
                        this.animationMode = Snackbar.ANIMATION_MODE_FADE
                        this.show()
                    }
                }


            })

    }
        // any function for epoxyController Callback
        private fun doSomething(title: String) {
        Snackbar.make(binding.root, "Se oprimio el title $title", Snackbar.LENGTH_SHORT)
            .show()
    }
}