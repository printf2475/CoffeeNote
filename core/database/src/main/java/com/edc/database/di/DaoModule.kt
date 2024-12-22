package com.edc.database.di

import com.edc.database.CoffeeNoteDataBase
import com.edc.database.dao.CoffeeNoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
    @Provides
    @Singleton
    fun providesCoffeeNoteDao(
        database: CoffeeNoteDataBase,
    ): CoffeeNoteDao = database.coffeeNoteDao()
}