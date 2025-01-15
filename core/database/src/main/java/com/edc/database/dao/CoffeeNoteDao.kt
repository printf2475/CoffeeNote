package com.edc.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.edc.database.model.CoffeeBeenInfoEntity
import com.edc.database.model.CoffeeNoteEntity
import com.edc.database.model.CoffeeNoteWithBeenInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeNoteDao {

    @Transaction
    @Query("SELECT * FROM coffee_note_entity")
    fun getCoffeeNoteAll(): Flow<List<CoffeeNoteWithBeenInfo>>

    @Query("SELECT * FROM coffee_note_entity WHERE id = :id")
    fun getCoffeeNoteById(id: String): Flow<CoffeeNoteWithBeenInfo>

    @Upsert
    fun upsertCoffeeNote(coffeeNoteEntityList: List<CoffeeNoteEntity>)

    @Upsert
    fun upsertCoffeeNote(coffeeNoteEntity: CoffeeNoteEntity)


    @Query("DELETE FROM coffee_note_entity WHERE id = :id")
    fun deleteCoffeeNoteById(id: String)

    @Query("SELECT * FROM been_info_entity")
    fun getCoffeeBeenAll(): Flow<List<CoffeeBeenInfoEntity>>

    @Query("SELECT * FROM been_info_entity WHERE id = :id")
    fun getCoffeeBeenById(id: String): Flow<CoffeeBeenInfoEntity>

    @Upsert
    fun upsertCoffeeBeen(coffeeBeenEntity: CoffeeBeenInfoEntity)

    @Query("DELETE FROM been_info_entity WHERE id = :id")
    fun deleteCoffeeBeenById(id: String)

}