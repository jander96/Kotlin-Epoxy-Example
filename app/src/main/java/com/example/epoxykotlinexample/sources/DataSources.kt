package com.example.epoxykotlinexample.sources


import android.content.Context
import com.example.epoxykotlinexample.R
import com.example.epoxykotlinexample.domain.Personage

class DataSources(private val context : Context) {
    private val listImagesBobSponge = listOf(
        R.drawable.home,
        R.drawable.porsche,
        R.drawable.pants_bob,
        R.drawable.restaurant,
        R.drawable.sky_globe,
        R.drawable.sponge_bob_pinaple_house,
        R.drawable.sponge_bob_toy,
        R.drawable.spongebob_christmas,
        R.drawable.spongebob_crystal_bol,
        R.drawable.spongebob_happy_face
    )
    private val listImagesPatrick = listOf(
        R.drawable.patricio,
        R.drawable.patrick_3d,
        R.drawable.patricio_one,
        R.drawable.patricio_running,
        R.drawable.patricio_winner,
        R.drawable.patricio_a_litle_boy,
        R.drawable.patricio_science_dude,
        R.drawable.bob_and_patrick_baby
    )
    private val listImagesCalamardo = listOf(
        R.drawable.calamardo,
        R.drawable.calamardo_big,
        R.drawable.calamardo_flaute,
        R.drawable.calamardo_guapo,
        R.drawable.calamardo_inlove,
        R.drawable.calamardo_pinter,
    )
    private val listImagesCangrejo = listOf(
        R.drawable.don_cangrejo,
        R.drawable.cangrejo_and_gold,
        R.drawable.cangrejo_and_money,
        R.drawable.cangrejo_calling,
        R.drawable.cangrejo_big_ice,
    )
    private val listImagesArenita = listOf(
        R.drawable.arenita,
        R.drawable.arenita_3d,
        R.drawable.arenita_afraid,
        R.drawable.little_arenita,
        R.drawable.four_friend,
    )

    val listOfPersonages: List<Personage> = listOf(
        Personage("Bob Esponja", listImagesBobSponge,context.applicationContext.getString(R.string.bob_sponge_description)),
        Personage("Patricio", listImagesPatrick,context.applicationContext.getString(R.string.patrick_description)),
        Personage("Don Cangrejo", listImagesCangrejo,context.applicationContext.getString(R.string.cangrejo_description)),
        Personage("Arenita", listImagesArenita,context.applicationContext.getString(R.string.arenita_description))
    )


}