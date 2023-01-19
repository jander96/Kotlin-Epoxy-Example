package com.example.epoxykotlinexample.crontroller

import com.airbnb.epoxy.EpoxyController
import com.example.epoxykotlinexample.models.TitleHeaderModel

class MainEpoxyController(
    val titles: List<String>,
    private val onClickCallBack: ()->Unit
): EpoxyController(){

    override fun buildModels() {
        if(titles.isNotEmpty()){
            requestModelBuild()
            titles.forEach{
                TitleHeaderModel(it){
                    onClickCallBack()
                }
            }
        }
    }
}