package com.edc.coffeenote.core.domain.usecase

import com.edc.coffeenote.core.data.repository.CoffeeBeenRepository
import javax.inject.Inject

class GetCoffeeBeenByIdUseCase @Inject constructor(
    private val coffeeBeenRepository: CoffeeBeenRepository
) {
    operator fun invoke(id: String) = coffeeBeenRepository.getCoffeeBeenById(id)
}