package com.example.epoxykotlinexample.controller

import com.airbnb.epoxy.EpoxyController
import com.example.epoxykotlinexample.domain.Personage
import com.example.epoxykotlinexample.models.BottomModel
import com.example.epoxykotlinexample.models.CarrouselModel
import com.example.epoxykotlinexample.models.DescriptionModel
import com.example.epoxykotlinexample.models.HeadModel

class MainEpoxyController(
    private val onClickCallBack: (String)->Unit
): EpoxyController(){
    var personages: List<Personage> = emptyList()
     set(value) {
         field = value
         requestModelBuild()
     }
    override fun buildModels() {
        HeadModel()
            .id("head")
            .addTo(this)
       personages.forEach { personage->
           CarrouselModel(personage)
               .id("carousel")
               .addTo(this)

       }
        personages.forEach {personage ->
            DescriptionModel(personage){
                onClickCallBack(personage.name)
            }.id("desc")
                .addTo(this)
        }
        BottomModel()
            .id("fin")
            .addTo(this)





    }
}
