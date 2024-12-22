package com.edc.database.di

import com.edc.database.CoffeeNoteDataBase
import com.edc.database.dao.CoffeeNoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
    @Provides
    fun providesTopicsDao(
        database: CoffeeNoteDataBase,
    ): CoffeeNoteDao = database.coffeeNoteDao()
}