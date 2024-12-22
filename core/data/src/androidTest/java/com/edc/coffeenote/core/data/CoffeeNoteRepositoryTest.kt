package com.edc.coffeenote.core.data

import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import com.edc.coffeenote.core.data.repository.DefaultCoffeeNoteRepository
import com.edc.coffeenote.core.model.BrewingStep
import com.edc.coffeenote.core.model.BrewingType
import com.edc.coffeenote.core.model.CoffeeNote
import com.edc.database.dao.CoffeeNoteDao
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Date
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class CoffeeNoteRepositoryTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    private lateinit var repository: CoffeeNoteRepository

    @Inject
    @Named("test_coffee_note_dao")
    lateinit var coffeeNoteDao: CoffeeNoteDao

    @Before
    fun init() {
        hiltRule.inject()
        repository = DefaultCoffeeNoteRepository(coffeeNoteDao = coffeeNoteDao)
    }

    @Test
    fun fetchCoffeeNoteListFromRepository() = runTest {
        val coffeeNoteList = listOf(
            CoffeeNote(
                coffeeName = "아메리카노",
                brewingRecipe = listOf(
                    BrewingStep(type = BrewingType.Bloom),
                    BrewingStep(type = BrewingType.Pouring),
                    BrewingStep(type = BrewingType.Pouring),
                    BrewingStep(type = BrewingType.Pouring),
                ),
                notes = "",
                date = Date().toGMTString()
            ),
            CoffeeNote(
                coffeeName = "라떼",
                brewingRecipe = listOf(
                    BrewingStep(type = BrewingType.Bloom),
                    BrewingStep(type = BrewingType.Pouring),
                    BrewingStep(type = BrewingType.Pouring),
                    BrewingStep(type = BrewingType.Pouring),
                ),
                notes = "",
                date = Date().toGMTString()
            ),
            CoffeeNote(
                coffeeName = "스페셜티",
                brewingRecipe = listOf(
                    BrewingStep(type = BrewingType.Bloom),
                    BrewingStep(type = BrewingType.Pouring),
                    BrewingStep(type = BrewingType.Pouring),
                    BrewingStep(type = BrewingType.Pouring),
                ),
                notes = "",
                date = Date().toGMTString()
            )
        )

        coffeeNoteList.forEach {
            repository.insertCoffeeNote(it)
        }

        val savedCoffeeNoteList = repository.getAllCoffeeNote().first()
        println("coffeeNoteList: $coffeeNoteList")
        println("savedCoffeeNoteList: $savedCoffeeNoteList")

        assertEquals(savedCoffeeNoteList, coffeeNoteList)
    }
}