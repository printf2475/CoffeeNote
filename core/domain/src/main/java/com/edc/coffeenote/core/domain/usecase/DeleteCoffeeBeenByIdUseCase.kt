package com.edc.coffeenote.core.domain.usecase

import com.edc.coffeenote.core.data.repository.CoffeeBeenRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteCoffeeBeenByIdUseCase @Inject constructor(
    private val coffeeBeenRepository: CoffeeBeenRepository
) {
    operator fun invoke(
        id: String, dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) = flow {
        withContext(dispatcher) { coffeeBeenRepository.deleteCoffeeBeen(id) }
        emit(Unit)
    }
}