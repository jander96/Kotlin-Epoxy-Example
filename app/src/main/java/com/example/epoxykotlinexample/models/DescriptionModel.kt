package com.example.epoxykotlinexample.models

import com.example.epoxykotlinexample.R
import com.example.epoxykotlinexample.databinding.DescriptionItemBinding
import com.example.epoxykotlinexample.domain.Personage


data class DescriptionModel(
    val personage : Personage,
    val onclick : ()-> Unit
) :ViewBindingKotlinModel<DescriptionItemBinding>(R.layout.description_item){
    override fun DescriptionItemBinding.bind() {
        personageName.text = personage.name
        title.text = personage.description
        title.setOnClickListener {
            onclick()
        }
    }

}
