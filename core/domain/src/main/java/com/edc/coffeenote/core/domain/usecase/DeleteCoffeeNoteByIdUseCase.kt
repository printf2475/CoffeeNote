package com.edc.coffeenote.core.domain.usecase

import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteCoffeeNoteByIdUseCase @Inject constructor(
    private val coffeeNoteRepository: CoffeeNoteRepository
) {
    operator fun invoke(
        id: String, dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) = flow {
        withContext(dispatcher) { coffeeNoteRepository.deleteCoffeeNote(id) }
        emit(Unit)
    }
}