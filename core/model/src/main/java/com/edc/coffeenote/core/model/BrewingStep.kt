package com.edc.coffeenote.core.model

data class BrewingStep(
    val type: BrewingType,
    val time: Int = type.defaultTime,
    val amountOfWater: Int? = null,
    val description: String? = null
)

enum class BrewingType(val defaultTime: Int) {
    Bloom(30),
    Pouring(10),
}