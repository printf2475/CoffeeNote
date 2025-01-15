package com.edc.coffeenote.core.data.repository

import com.edc.coffeenote.core.model.CoffeeBeenInfo
import kotlinx.coroutines.flow.Flow

interface CoffeeBeenRepository {

    fun getAllCoffeeBeen(): Flow<List<CoffeeBeenInfo>>

    fun getCoffeeBeenById(id: String): Flow<CoffeeBeenInfo>

    suspend fun upsertCoffeeBeen(coffeeBeen: CoffeeBeenInfo)

    suspend fun deleteCoffeeBeen(id: String)
}