package com.edc.coffeenote.core.model

import java.util.Date
import java.util.UUID

data class BrewingRecipe(
    val id: String = UUID.randomUUID().toString(),
    val name: String? = null,
    val method: CoffeeBrewingMethod = CoffeeBrewingMethod.HAND_DRIP,
    val steps: List<BrewingStep> = emptyList(),
    val date: Date = Date(),
){
    val pouringAmountList: List<Int>
        get() = steps.filter { it.type == BrewingStepType.POURING }
            .mapNotNull { it.amountOfWater }
}

enum class CoffeeBrewingMethod {
    HAND_DRIP,
    ESPRESSO,
    FRENCH_PRESS,
    COLD_BREW,
    AERO_PRESS
}

data class BrewingStep(
    val type: BrewingStepType = BrewingStepType.BLOOM,
    val time: Int = type.defaultTime,
    val amountOfWater: Int? = null,
    val description: String? = null
)

enum class BrewingStepType(val defaultTime: Int) {
    BLOOM(30),
    POURING(10),
}