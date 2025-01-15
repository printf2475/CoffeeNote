package com.edc.coffeenote.core.data.di

import com.edc.coffeenote.core.data.repository.CoffeeBeenRepository
import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import com.edc.coffeenote.core.data.repository.DefaultCoffeeBeenRepository
import com.edc.coffeenote.core.data.repository.DefaultCoffeeNoteRepository
import com.edc.coffeenote.core.data.repository.TestCoffeeNoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsCoffeeNoteRepository(
        coffeeNoteRepository: DefaultCoffeeNoteRepository
    ): CoffeeNoteRepository

    @Binds
    @Singleton
    @Named("test_coffee_note_repository")
    fun bindsTestCoffeeNoteRepository(
        coffeeNoteRepository: TestCoffeeNoteRepository
    ): CoffeeNoteRepository

    @Binds
    @Singleton
    fun bindsCoffeeBeenRepository(
        coffeeBeenRepository: DefaultCoffeeBeenRepository
    ): CoffeeBeenRepository

}