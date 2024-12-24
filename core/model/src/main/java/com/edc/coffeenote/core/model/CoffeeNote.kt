package com.edc.coffeenote.core.model

import kotlinx.collections.immutable.PersistentList
import java.util.UUID

data class CoffeeNote(
    val id: String = UUID.randomUUID().toString(),
    val beenInfo: BeenInfo,
    val brewingRecipe: List<BrewingStep>,
    val flavorPoint: Int? = null,
    val notes: String? = null,
    val date: String
) {
    val pouringAmountList: List<Int>
        get() = brewingRecipe.filter { it.type == BrewingType.Pouring }
            .mapNotNull { it.amountOfWater }
}

data class BeenInfo(
    val beenName: String,
    val roastery: String? = null,
    val flavorNotes: PersistentList<String>? = null,
    val roastingPoint: Int? = null,
)