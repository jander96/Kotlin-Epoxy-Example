package com.example.epoxykotlinexample.models

import com.example.epoxykotlinexample.R
import com.example.epoxykotlinexample.databinding.HeaderViewBinding

data class TitleHeaderModel(
    val titulo : String,
    val onclick : ()-> Unit
) :ViewBindingKotlinModel<HeaderViewBinding>(R.layout.header_view){
    override fun HeaderViewBinding.bind() {
        title.text = titulo
        title.setOnClickListener {
            onclick()
        }
    }

}
