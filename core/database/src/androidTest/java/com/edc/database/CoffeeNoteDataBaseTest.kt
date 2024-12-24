package com.edc.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.edc.database.dao.CoffeeNoteDao
import com.edc.database.model.BeenInfoEntity
import com.edc.database.model.BrewingStepEntity
import com.edc.database.model.BrewingTypeEntity
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
                beenInfo = BeenInfoEntity(
                    beenName = "KITSCH",
                    roastery = "아이덴티티 커피랩"
                ),
                brewingRecipe = listOf(
                    BrewingStepEntity(type = BrewingTypeEntity.Bloom),
                    BrewingStepEntity(type = BrewingTypeEntity.Pouring),
                    BrewingStepEntity(type = BrewingTypeEntity.Pouring),
                    BrewingStepEntity(type = BrewingTypeEntity.Pouring),
                ),
                notes = "",
                date = Date().toGMTString()
            ),
            CoffeeNoteEntity(
                beenInfo = BeenInfoEntity(
                    beenName = "CHILLIN",
                    roastery = "아이덴티티 커피랩"
                ),
                brewingRecipe = listOf(
                    BrewingStepEntity(type = BrewingTypeEntity.Bloom),
                    BrewingStepEntity(type = BrewingTypeEntity.Pouring),
                    BrewingStepEntity(type = BrewingTypeEntity.Pouring),
                    BrewingStepEntity(type = BrewingTypeEntity.Pouring),
                ),
                notes = "",
                date = Date().toGMTString()
            ),
            CoffeeNoteEntity(
                beenInfo = BeenInfoEntity(
                    beenName = "MID-CENTURY",
                    roastery = "아이덴티티 커피랩"
                ),
                brewingRecipe = listOf(
                    BrewingStepEntity(type = BrewingTypeEntity.Bloom),
                    BrewingStepEntity(type = BrewingTypeEntity.Pouring),
                    BrewingStepEntity(type = BrewingTypeEntity.Pouring),
                    BrewingStepEntity(type = BrewingTypeEntity.Pouring),
                ),
                notes = "",
                date = Date().toGMTString()
            )
        )

        coffeeNoteDao.upsert(coffeeNoteList)

        val savedCoffeeNoteList = coffeeNoteDao.getAll().first()

        assertEquals(savedCoffeeNoteList, coffeeNoteList)
    }
}