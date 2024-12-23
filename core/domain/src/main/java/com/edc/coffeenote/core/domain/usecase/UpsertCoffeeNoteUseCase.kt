package com.edc.coffeenote.core.domain.usecase

import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import com.edc.coffeenote.core.model.CoffeeNote
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpsertCoffeeNoteUseCase @Inject constructor(
    private val coffeeNoteRepository: CoffeeNoteRepository
) {
    suspend operator fun invoke(
        coffeeNote: CoffeeNote, dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) = flow {
        withContext(dispatcher) { coffeeNoteRepository.upsertCoffeeNote(coffeeNote) }
        emit(Unit)
    }
}