package com.edc.coffeenote.core.data.repository

import com.edc.coffeenote.core.model.CoffeeNote
import kotlinx.coroutines.flow.Flow

interface CoffeeNoteRepository {

    fun getAllCoffeeNote(): Flow<List<CoffeeNote>>

    fun getCoffeeNoteById(id: String): Flow<CoffeeNote>

    suspend fun upsertCoffeeNote(coffeeNote: CoffeeNote)

    suspend fun deleteCoffeeNote(id: String)
}