package com.edc.coffeenote.core.data.repository

import com.edc.coffeenote.core.model.CoffeeNote
import com.edc.database.dao.CoffeeNoteDao
import com.edc.database.mapper.toEntity
import com.edc.database.mapper.toModel
import com.edc.database.model.CoffeeNoteWithBeenInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

internal class TestCoffeeNoteRepository @Inject constructor(
    @Named("test_coffee_note_dao") private val coffeeNoteDao: CoffeeNoteDao
) : CoffeeNoteRepository {
    override fun getAllCoffeeNote(): Flow<List<CoffeeNote>> =
        coffeeNoteDao.getCoffeeNoteAll().map { it.map(CoffeeNoteWithBeenInfo::toModel) }

    override fun getCoffeeNoteById(id: String): Flow<CoffeeNote> =
        coffeeNoteDao.getCoffeeNoteById(id).map(CoffeeNoteWithBeenInfo::toModel)

    override suspend fun upsertCoffeeNote(coffeeNote: CoffeeNote) =
        coffeeNoteDao.upsertCoffeeNote(coffeeNote.toEntity())

    override suspend fun deleteCoffeeNote(id: String) =
        coffeeNoteDao.deleteCoffeeNoteById(id)
}