package com.edc.coffeenote.core.data.di

import com.edc.coffeenote.core.data.repository.CoffeeNoteRepository
import com.edc.coffeenote.core.data.repository.DefaultCoffeeNoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsCoffeeNoteRepository(
        coffeeNoteRepository: DefaultCoffeeNoteRepository
    ): CoffeeNoteRepository

}