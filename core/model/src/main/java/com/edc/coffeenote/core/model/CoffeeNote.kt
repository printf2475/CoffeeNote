package com.edc.coffeenote.core.model

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import java.util.Date
import java.util.UUID

data class CoffeeNote(
    val id: String = UUID.randomUUID().toString(),
    val coffeeBeenInfo: CoffeeBeenInfo = CoffeeBeenInfo(),
    val brewingRecipeList: PersistentList<BrewingRecipe> = persistentListOf(),
    val notes: String? = null,
    val date: Date = Date()
)


data class CoffeeBeenInfo(
    val id: String = UUID.randomUUID().toString(),
    val beenName: String = "",
    val roastery: String? = null,
    val flavorNotes: PersistentList<String> = persistentListOf(),
    val roastingPoint: Int = 3,
    val roastingDate: Date = Date()
)