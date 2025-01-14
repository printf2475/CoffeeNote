package com.edc.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.UUID

data class CoffeeNoteWithBeenInfo(
    @Embedded val coffeeNote: CoffeeNoteEntity,
    @Relation(
        parentColumn = "been_info_id",
        entityColumn = "id"
    )
    val beenInfo: BeenInfoEntity
)

@Entity(tableName = "coffee_note_entity")
data class CoffeeNoteEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo("been_info_id")
    val beenInfoId: String,
    @ColumnInfo(name = "brewing_recipe_list")
    val brewingRecipeList: List<BrewingRecipeEntity>,
    @ColumnInfo("notes")
    val notes: String? = null,
    @ColumnInfo("date")
    val date: Long
)

@Entity(tableName = "been_info_entity")
data class BeenInfoEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo("been_name")
    val beenName: String,
    @ColumnInfo("roastery")
    val roastery: String? = null,
    @ColumnInfo("flavor_notes")
    val flavorNotes: List<String> = emptyList(),
    @ColumnInfo("roasting_point")
    val roastingPoint: Int = 3,
)

