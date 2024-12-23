package com.edc.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.edc.database.model.CoffeeNoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeNoteDao {
    @Query("SELECT * FROM coffee_note_entity")
    fun getAll(): Flow<List<CoffeeNoteEntity>>

    @Query("SELECT * FROM coffee_note_entity WHERE id = :id")
    fun getById(id: String): Flow<CoffeeNoteEntity>

    @Upsert
    fun upsert(coffeeNoteEntityList: List<CoffeeNoteEntity>)

    @Upsert
    fun upsert(coffeeNoteEntity: CoffeeNoteEntity)


    @Query("DELETE FROM coffee_note_entity WHERE id = :id")
    fun deleteById(id: String)


}