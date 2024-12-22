package com.edc.coffeenote.core.model

import java.util.UUID

data class CoffeeNote(
    val id: String = UUID.randomUUID().toString(),
    val coffeeName: String,
    val brewingRecipe: List<BrewingStep>,
    val notes: String? = null,
    val date: String
)