package com.edc.coffeenote.core.data.repository

import com.edc.coffeenote.core.model.CoffeeNote
import com.edc.database.dao.CoffeeNoteDao
import com.edc.database.mapper.toEntity
import com.edc.database.mapper.toModel
import com.edc.database.model.CoffeeNoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultCoffeeNoteRepository(
    private val coffeeNoteDao: CoffeeNoteDao
) : CoffeeNoteRepository {
    override fun getAllCoffeeNote(): Flow<List<CoffeeNote>> =
        coffeeNoteDao.getAll().map { it.map(CoffeeNoteEntity::toModel) }

    override fun getCoffeeNoteById(id: String): Flow<CoffeeNote> =
        coffeeNoteDao.getById(id).map(CoffeeNoteEntity::toModel)

    override suspend fun insertCoffeeNote(coffeeNote: CoffeeNote) =
        coffeeNoteDao.insert(coffeeNote.toEntity())

    override suspend fun updateCoffeeNote(coffeeNote: CoffeeNote) =
        coffeeNoteDao.upsert(coffeeNote.toEntity())

    override suspend fun deleteCoffeeNote(id: String) =
        coffeeNoteDao.deleteById(id)
}