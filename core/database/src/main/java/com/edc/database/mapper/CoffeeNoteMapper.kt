package com.edc.database.mapper

import com.edc.coffeenote.core.model.BeenInfo
import com.edc.coffeenote.core.model.BrewingRecipe
import com.edc.coffeenote.core.model.BrewingStep
import com.edc.coffeenote.core.model.BrewingStepType
import com.edc.coffeenote.core.model.CoffeeBrewingMethod
import com.edc.coffeenote.core.model.CoffeeNote
import com.edc.database.model.BeenInfoEntity
import com.edc.database.model.BrewingRecipeEntity
import com.edc.database.model.BrewingStepEntity
import com.edc.database.model.BrewingStepTypeEntity
import com.edc.database.model.CoffeeBrewingMethodEntity
import com.edc.database.model.CoffeeNoteEntity
import com.edc.database.model.CoffeeNoteWithBeenInfo
import kotlinx.collections.immutable.toPersistentList
import java.util.Date

fun CoffeeNote.toEntity() = CoffeeNoteEntity(
    id = id,
    beenInfoId = beenInfo.id,
    brewingRecipeList = brewingRecipeList.map(BrewingRecipe::toEntity),
    notes = notes,
    date = date.time
)

fun CoffeeNoteWithBeenInfo.toModel() = CoffeeNote(
    id = coffeeNote.id,
    beenInfo = beenInfo.toModel(),
    brewingRecipeList = coffeeNote.brewingRecipeList.map(BrewingRecipeEntity::toModel).toPersistentList(),
    notes = coffeeNote.notes,
    date = Date(coffeeNote.date)
)

fun BrewingRecipe.toEntity() = BrewingRecipeEntity(
    recipeId = id,
    name = name,
    method = method.toEntity(),
    steps = steps.map(BrewingStep::toEntity),
    date = date
)

fun BrewingRecipeEntity.toModel() = BrewingRecipe(
    id = recipeId,
    name = name,
    method = method.toModel(),
    steps = steps.map(BrewingStepEntity::toModel),
    date = date
)

fun CoffeeBrewingMethodEntity.toModel() = when (this) {
    CoffeeBrewingMethodEntity.HAND_DRIP -> CoffeeBrewingMethod.HAND_DRIP
    CoffeeBrewingMethodEntity.ESPRESSO -> CoffeeBrewingMethod.ESPRESSO
    CoffeeBrewingMethodEntity.FRENCH_PRESS -> CoffeeBrewingMethod.FRENCH_PRESS
    CoffeeBrewingMethodEntity.COLD_BREW -> CoffeeBrewingMethod.COLD_BREW
    CoffeeBrewingMethodEntity.AERO_PRESS -> CoffeeBrewingMethod.AERO_PRESS
}

fun CoffeeBrewingMethod.toEntity() = when (this) {
    CoffeeBrewingMethod.HAND_DRIP -> CoffeeBrewingMethodEntity.HAND_DRIP
    CoffeeBrewingMethod.ESPRESSO -> CoffeeBrewingMethodEntity.ESPRESSO
    CoffeeBrewingMethod.FRENCH_PRESS -> CoffeeBrewingMethodEntity.FRENCH_PRESS
    CoffeeBrewingMethod.COLD_BREW -> CoffeeBrewingMethodEntity.COLD_BREW
    CoffeeBrewingMethod.AERO_PRESS -> CoffeeBrewingMethodEntity.AERO_PRESS
}


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

fun BrewingStepType.toEntity() = when (this) {
    BrewingStepType.BLOOM -> BrewingStepTypeEntity.BLOOM
    BrewingStepType.POURING -> BrewingStepTypeEntity.POURING
}

fun BrewingStepTypeEntity.toModel() = when (this) {
    BrewingStepTypeEntity.BLOOM -> BrewingStepType.BLOOM
    BrewingStepTypeEntity.POURING -> BrewingStepType.POURING
}

fun BeenInfo.toEntity() = BeenInfoEntity(
    beenName = beenName,
    roastery = roastery,
    flavorNotes = flavorNotes,
    roastingPoint = roastingPoint
)

fun BeenInfoEntity.toModel() = BeenInfo(
    beenName = beenName,
    roastery = roastery,
    flavorNotes = flavorNotes.toPersistentList(),
    roastingPoint = roastingPoint
)
