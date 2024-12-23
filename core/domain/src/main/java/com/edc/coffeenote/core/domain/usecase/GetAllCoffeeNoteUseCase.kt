package com.edc.coffeenote.core.domain.usecase

import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import javax.inject.Inject

class GetAllCoffeeNoteUseCase @Inject constructor(
    private val coffeeNoteRepository: CoffeeNoteRepository
) {
    operator fun invoke() = coffeeNoteRepository.getAllCoffeeNote()
}