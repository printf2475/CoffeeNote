package com.edc.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "coffee_note_entity")
data class CoffeeNoteEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "coffee_name")
    val coffeeName: String,
    @ColumnInfo(name = "brewing_recipe")
    val brewingRecipe: List<BrewingStepEntity>,
    val notes: String? = null,
    val date: String
)

data class BrewingStepEntity(
    val type: BrewingTypeEntity,
    val time: Int = type.defaultTime,
    val amountOfWater: Int? = null,
    val description: String? = null
)

enum class BrewingTypeEntity(val defaultTime: Int) {
    Bloom(30),
    Pouring(10),
}

