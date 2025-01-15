package com.edc.coffeenote.core.domain.usecase

import com.edc.coffeenote.core.data.repository.CoffeeBeenRepository
import com.edc.coffeenote.core.model.CoffeeBeenInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpsertCoffeeBeenUseCase @Inject constructor(
    private val coffeeBeenRepository: CoffeeBeenRepository
) {
    suspend operator fun invoke(
        coffeeBeenInfo: CoffeeBeenInfo,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) = flow {
        withContext(dispatcher) { coffeeBeenRepository.upsertCoffeeBeen(coffeeBeenInfo) }
        emit(Unit)
    }
}