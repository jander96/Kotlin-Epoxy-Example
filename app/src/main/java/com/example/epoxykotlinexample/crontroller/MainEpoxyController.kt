package com.example.epoxykotlinexample.crontroller

import com.airbnb.epoxy.EpoxyController
import com.example.epoxykotlinexample.models.ImageEpoxyModel
import com.example.epoxykotlinexample.models.TitleHeaderModel
import java.util.*

class MainEpoxyController(
    private val onClickCallBack: (String) -> Unit
) : EpoxyController() {
    var titles: List<String> = Collections.emptyList()
    set(value){
        field = value
        requestModelBuild()
    }
    override fun buildModels() {
        if (titles.isNotEmpty()) {

            titles.forEach {
                TitleHeaderModel(it) {
                    onClickCallBack(it)
                }.id("my_id")
                    .addTo(this)

                ImageEpoxyModel()
                    .id("epoxy_image_model")
                    .addTo(this)
            }



        }
    }
}