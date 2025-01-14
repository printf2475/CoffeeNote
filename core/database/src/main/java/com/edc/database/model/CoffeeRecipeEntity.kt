package com.edc.database.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID


data class BrewingRecipeEntity(
    @PrimaryKey
    val recipeId: String = UUID.randomUUID().toString(),
    @ColumnInfo("name")
    val name: String? = null,
    @ColumnInfo("method")
    val method: CoffeeBrewingMethodEntity = CoffeeBrewingMethodEntity.HAND_DRIP,
    @ColumnInfo("steps")
    val steps: List<BrewingStepEntity> = emptyList(),
    @ColumnInfo("date")
    val date: Date = Date(),
)


enum class CoffeeBrewingMethodEntity {
    HAND_DRIP, ESPRESSO, FRENCH_PRESS, COLD_BREW, AERO_PRESS
}


data class BrewingStepEntity(
    @ColumnInfo("type")
    val type: BrewingStepTypeEntity,
    @ColumnInfo("time")
    val time: Int = type.defaultTime,
    @ColumnInfo("amount_of_water")
    val amountOfWater: Int? = null,
    @ColumnInfo("description")
    val description: String? = null
)

enum class BrewingStepTypeEntity(val defaultTime: Int) {
    BLOOM(30),
    POURING(10),
}


