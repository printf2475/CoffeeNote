package com.edc.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.collections.immutable.PersistentList
import java.util.UUID

@Entity(tableName = "coffee_note_entity")
data class CoffeeNoteEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo("been_info")
    val beenInfo: BeenInfoEntity,
    @ColumnInfo(name = "brewing_recipe")
    val brewingRecipe: List<BrewingStepEntity>,
    @ColumnInfo("flavor_point")
    val flavorPoint: Int? = null,
    val notes: String? = null,
    val date: String
)

data class BrewingStepEntity(
    val type: BrewingTypeEntity,
    val time: Int = type.defaultTime,
    @ColumnInfo("amount_of_water")
    val amountOfWater: Int? = null,
    val description: String? = null
)

enum class BrewingTypeEntity(val defaultTime: Int) {
    Bloom(30),
    Pouring(10),
}

data class BeenInfoEntity(
    @ColumnInfo("been_name")
    val beenName: String,
    val roastery: String? = null,
    @ColumnInfo("flavor_notes")
    val flavorNotes: PersistentList<String>? = null,
    @ColumnInfo("roasting_point")
    val roastingPoint: Int? = null,
)

