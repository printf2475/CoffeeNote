package com.edc.database.mapper

import com.edc.coffeenote.core.model.BrewingStep
import com.edc.coffeenote.core.model.BrewingType
import com.edc.coffeenote.core.model.CoffeeNote
import com.edc.database.model.BrewingStepEntity
import com.edc.database.model.BrewingTypeEntity
import com.edc.database.model.CoffeeNoteEntity

fun CoffeeNote.toEntity() = CoffeeNoteEntity(
    id = id,
    coffeeName = coffeeName,
    brewingRecipe = brewingRecipe.map(BrewingStep::toEntity),
    notes = notes,
    date = date
)

fun CoffeeNoteEntity.toModel() = CoffeeNote(
    id = id,
    coffeeName = coffeeName,
    brewingRecipe = brewingRecipe.map(BrewingStepEntity::toModel),
    notes = notes,
    date = date
)

fun BrewingStepEntity.toModel() = BrewingStep(
    type = type.toModel(),
    time = time,
    amountOfWater = amountOfWater,
    description = description
)

fun BrewingStep.toEntity() = BrewingStepEntity(
    type = type.toEntity(),
    time = time,
    amountOfWater = amountOfWater,
    description = description
)

fun BrewingType.toEntity() = when (this) {
    BrewingType.Bloom -> BrewingTypeEntity.Bloom
    BrewingType.Pouring -> BrewingTypeEntity.Pouring
}

fun BrewingTypeEntity.toModel() = when (this) {
    BrewingTypeEntity.Bloom -> BrewingType.Bloom
    BrewingTypeEntity.Pouring -> BrewingType.Pouring
}

