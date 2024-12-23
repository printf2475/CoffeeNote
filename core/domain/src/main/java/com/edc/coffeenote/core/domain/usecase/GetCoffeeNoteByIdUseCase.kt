package com.edc.coffeenote.core.domain.usecase

import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import javax.inject.Inject

class GetCoffeeNoteByIdUseCase @Inject constructor(
    private val coffeeNoteRepository: CoffeeNoteRepository
) {
    operator fun invoke(id: String) = coffeeNoteRepository.getCoffeeNoteById(id)
}