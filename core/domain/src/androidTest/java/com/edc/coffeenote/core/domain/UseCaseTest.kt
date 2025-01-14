package com.edc.coffeenote.core.domain

import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import com.edc.coffeenote.core.domain.usecase.DeleteCoffeeNoteByIdUseCase
import com.edc.coffeenote.core.domain.usecase.GetAllCoffeeNoteUseCase
import com.edc.coffeenote.core.domain.usecase.GetCoffeeNoteByIdUseCase
import com.edc.coffeenote.core.domain.usecase.UpsertCoffeeNoteUseCase
import com.edc.coffeenote.core.model.BeenInfo
import com.edc.coffeenote.core.model.BrewingRecipe
import com.edc.coffeenote.core.model.CoffeeBrewingMethod
import com.edc.coffeenote.core.model.CoffeeNote
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.collections.immutable.toPersistentList
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

    private val coffeeNoteSample = CoffeeNote(
        beenInfo = BeenInfo(
            beenName = "KITSCH",
            roastery = "아이덴티티 커피랩"
        ),
        brewingRecipeList = listOf(
            BrewingRecipe(
                name = "4:6",
                method = CoffeeBrewingMethod.HAND_DRIP,
                steps = listOf(),
                date = Date()
            ),
            BrewingRecipe(
                name = "테츠야 레시피",
                method = CoffeeBrewingMethod.HAND_DRIP,
                steps = listOf(),
                date = Date()
            ),
            BrewingRecipe(
                name = "기본 레시피",
                method = CoffeeBrewingMethod.HAND_DRIP,
                steps = listOf(),
                date = Date()
            ),
        ).toPersistentList(),
        date = Date()
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
    fun getCoffeeNoteById() = runTest {
        val upsertCoffeeNoteUseCase = UpsertCoffeeNoteUseCase(coffeeNoteRepository)
        upsertCoffeeNoteUseCase(coffeeNoteSample).collect()

        val getCoffeeNoteByIdUseCase = GetCoffeeNoteByIdUseCase(coffeeNoteRepository)
        val coffeeNote = getCoffeeNoteByIdUseCase(coffeeNoteSample.id).first()
        println("coffeeNote: $coffeeNote")
        assert(coffeeNote == coffeeNoteSample)
    }

    @Test
    fun upsertCoffeeNote() = runTest {
        val upsertCoffeeNoteUseCase = UpsertCoffeeNoteUseCase(coffeeNoteRepository)
        upsertCoffeeNoteUseCase(coffeeNoteSample).collect()

        val copyCoffeeNoteSample = coffeeNoteSample.copy(
            beenInfo = coffeeNoteSample.beenInfo.copy(
                beenName = "스타벅스 홀빈",
                roastery = "스타벅스"
            )
        )
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