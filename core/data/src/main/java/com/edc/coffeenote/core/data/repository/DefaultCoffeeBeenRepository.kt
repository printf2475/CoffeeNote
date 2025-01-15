package com.edc.coffeenote.core.data.repository

import com.edc.coffeenote.core.model.CoffeeBeenInfo
import com.edc.database.dao.CoffeeNoteDao
import com.edc.database.mapper.toEntity
import com.edc.database.mapper.toModel
import com.edc.database.model.CoffeeBeenInfoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultCoffeeBeenRepository @Inject constructor(
    private val coffeeNoteDao: CoffeeNoteDao
) : CoffeeBeenRepository {
    override fun getAllCoffeeBeen(): Flow<List<CoffeeBeenInfo>> =
        coffeeNoteDao.getCoffeeBeenAll().map { it.map(CoffeeBeenInfoEntity::toModel) }

    override fun getCoffeeBeenById(id: String): Flow<CoffeeBeenInfo> =
        coffeeNoteDao.getCoffeeBeenById(id).map(CoffeeBeenInfoEntity::toModel)

    override suspend fun upsertCoffeeBeen(coffeeBeen: CoffeeBeenInfo) =
        coffeeNoteDao.upsertCoffeeBeen(coffeeBeen.toEntity())

    override suspend fun deleteCoffeeBeen(id: String) =
        coffeeNoteDao.deleteCoffeeBeenById(id)

}