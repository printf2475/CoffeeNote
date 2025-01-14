package com.edc.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.edc.database.dao.CoffeeNoteDao
import com.edc.database.model.BrewingRecipeEntity
import com.edc.database.model.CoffeeBrewingMethodEntity
import com.edc.database.model.CoffeeNoteEntity
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.Date

class CoffeeNoteDataBaseTest {
    private lateinit var coffeeNoteDao: CoffeeNoteDao
    private lateinit var db: CoffeeNoteDataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            CoffeeNoteDataBase::class.java,
        ).build()
        coffeeNoteDao = db.coffeeNoteDao()
    }

    @After
    fun closeDb() = db.close()

    @Test
    fun fetchCoffeeNoteListFromDB() = runTest {
        val coffeeNoteList = listOf(
            CoffeeNoteEntity(
                beenInfoId = "1",
                brewingRecipeList = listOf(
                    BrewingRecipeEntity(method = CoffeeBrewingMethodEntity.HAND_DRIP),
                    BrewingRecipeEntity(method = CoffeeBrewingMethodEntity.HAND_DRIP),
                    BrewingRecipeEntity(method = CoffeeBrewingMethodEntity.HAND_DRIP),
                ),
                notes = "",
                date = Date().time
            ),
            CoffeeNoteEntity(
                beenInfoId = "1",
                brewingRecipeList = listOf(
                    BrewingRecipeEntity(method = CoffeeBrewingMethodEntity.HAND_DRIP),
                    BrewingRecipeEntity(method = CoffeeBrewingMethodEntity.HAND_DRIP),
                    BrewingRecipeEntity(method = CoffeeBrewingMethodEntity.HAND_DRIP),
                ),
                notes = "",
                date = Date().time
            ),
            CoffeeNoteEntity(
                beenInfoId = "1",
                brewingRecipeList = listOf(
                    BrewingRecipeEntity(method = CoffeeBrewingMethodEntity.HAND_DRIP),
                    BrewingRecipeEntity(method = CoffeeBrewingMethodEntity.HAND_DRIP),
                    BrewingRecipeEntity(method = CoffeeBrewingMethodEntity.HAND_DRIP),
                ),
                notes = "",
                date = Date().time
            )
        )

        coffeeNoteDao.upsertCoffeeNote(coffeeNoteList)

        val savedCoffeeNoteList = coffeeNoteDao.getCoffeeNoteAll().first()

        assertEquals(savedCoffeeNoteList, coffeeNoteList)
    }
}