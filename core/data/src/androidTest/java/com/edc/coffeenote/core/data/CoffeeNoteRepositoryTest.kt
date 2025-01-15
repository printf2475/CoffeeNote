package com.edc.coffeenote.core.data

import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import com.edc.coffeenote.core.data.repository.DefaultCoffeeNoteRepository
import com.edc.coffeenote.core.model.CoffeeBeenInfo
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
                coffeeBeenInfo = CoffeeBeenInfo(
                    beenName = "KITSCH",
                    roastery = "아이덴티티 커피랩"
                ),
                notes = "",
                date = Date()
            ),
            CoffeeNote(
                coffeeBeenInfo = CoffeeBeenInfo(
                    beenName = "CHILLIN",
                    roastery = "아이덴티티 커피랩"
                ),
                notes = "",
                date = Date()
            ),
            CoffeeNote(
                coffeeBeenInfo = CoffeeBeenInfo(
                    beenName = "MID-CENTURY",
                    roastery = "아이덴티티 커피랩"
                ),
                notes = "",
                date = Date()
            )
        )

        coffeeNoteList.forEach {
            repository.upsertCoffeeNote(it)
        }

        val savedCoffeeNoteList = repository.getAllCoffeeNote().first()
        println("coffeeNoteList: $coffeeNoteList")
        println("savedCoffeeNoteList: $savedCoffeeNoteList")

        assertEquals(savedCoffeeNoteList, coffeeNoteList)
    }
}