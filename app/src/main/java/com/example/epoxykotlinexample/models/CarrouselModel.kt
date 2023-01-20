package com.example.epoxykotlinexample.models


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.epoxykotlinexample.R
import com.example.epoxykotlinexample.databinding.CarouselViewBinding
import com.example.epoxykotlinexample.domain.Personage

import com.example.epoxykotlinexample.view.CarouselAdapter

data class CarrouselModel(
    val personage : Personage
): ViewBindingKotlinModel<CarouselViewBinding>(R.layout.carousel_view) {
    override fun CarouselViewBinding.bind() {
        tvCartoonTitle.text = personage.name
        epoxyRecyclerView.layoutManager =
            LinearLayoutManager(epoxyRecyclerView.context,LinearLayoutManager.HORIZONTAL,false)
        epoxyRecyclerView.adapter = CarouselAdapter().also { adapter->
            adapter.submitList(personage.images)
        }
    }
}
