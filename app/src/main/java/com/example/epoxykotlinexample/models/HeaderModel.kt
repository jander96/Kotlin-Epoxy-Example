package com.example.epoxykotlinexample.models

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxykotlinexample.R
import com.example.epoxykotlinexample.models.HeaderModel.*

@EpoxyModelClass(layout = R.layout.header_view)
abstract class HeaderModel : EpoxyModelWithHolder<Holder>() {
    @EpoxyAttribute lateinit var title : String

    class Holder:EpoxyHolder()  {
        override fun bindView(itemView: View) {
            TODO("Not yet implemented")
        }

    }

}