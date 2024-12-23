package com.edc.coffeenote.core.domain

import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import com.edc.coffeenote.core.domain.usecase.DeleteCoffeeNoteByIdUseCase
import com.edc.coffeenote.core.domain.usecase.GetAllCoffeeNoteUseCase
import com.edc.coffeenote.core.domain.usecase.UpsertCoffeeNoteUseCase
import com.edc.coffeenote.core.model.BrewingStep
import com.edc.coffeenote.core.model.BrewingType
import com.edc.coffeenote.core.model.CoffeeNote
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Date
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class UseCaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("test_coffee_note_repository")
    lateinit var coffeeNoteRepository: CoffeeNoteRepository

    val coffeeNoteSample = CoffeeNote(
        coffeeName = "아메리카노",
        brewingRecipe = listOf(
            BrewingStep(type = BrewingType.Bloom),
            BrewingStep(type = BrewingType.Pouring),
            BrewingStep(type = BrewingType.Pouring),
            BrewingStep(type = BrewingType.Pouring),
        ),
        date = Date().toString()
    )

    @Before
    fun init() {
        hiltRule.inject()
    }

    @After
    fun clear() {
        val deleteCoffeeNoteByIdUseCase = DeleteCoffeeNoteByIdUseCase(coffeeNoteRepository)
        deleteCoffeeNoteByIdUseCase(coffeeNoteSample.id)
    }

    @Test
    fun getAllCoffeeNote() = runTest {
        val upsertCoffeeNoteUseCase = UpsertCoffeeNoteUseCase(coffeeNoteRepository)
        upsertCoffeeNoteUseCase(coffeeNoteSample).collect()
        val getAllCoffeeNoteUseCase = GetAllCoffeeNoteUseCase(coffeeNoteRepository)
        val coffeeNoteList = getAllCoffeeNoteUseCase().first()
        println("coffeeNoteList: $coffeeNoteList")
        assert(coffeeNoteList.contains(coffeeNoteSample))
    }

    @Test
    fun upsertCoffeeNote() = runTest {
        val upsertCoffeeNoteUseCase = UpsertCoffeeNoteUseCase(coffeeNoteRepository)
        upsertCoffeeNoteUseCase(coffeeNoteSample).collect()

        val copyCoffeeNoteSample = coffeeNoteSample.copy(coffeeName = "라떼")
        upsertCoffeeNoteUseCase(copyCoffeeNoteSample).collect()

        val getAllCoffeeNoteUseCase = GetAllCoffeeNoteUseCase(coffeeNoteRepository)
        val coffeeNoteList = getAllCoffeeNoteUseCase().first()
        println("coffeeNoteList: $coffeeNoteList")
        assert(coffeeNoteList.contains(copyCoffeeNoteSample))
    }


    @Test
    fun deleteCoffeeNoteById() = runTest {
        val upsertCoffeeNoteUseCase = UpsertCoffeeNoteUseCase(coffeeNoteRepository)
        upsertCoffeeNoteUseCase(coffeeNoteSample).collect()
        val deleteCoffeeNoteByIdUseCase = DeleteCoffeeNoteByIdUseCase(coffeeNoteRepository)
        deleteCoffeeNoteByIdUseCase(coffeeNoteSample.id).collect()

        val getAllCoffeeNoteUseCase = GetAllCoffeeNoteUseCase(coffeeNoteRepository)
        val coffeeNoteList = getAllCoffeeNoteUseCase().first()
        println("coffeeNoteList: $coffeeNoteList")
        assert(!coffeeNoteList.contains(coffeeNoteSample))
    }
}