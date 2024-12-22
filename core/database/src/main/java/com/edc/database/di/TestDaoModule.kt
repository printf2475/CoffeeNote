package com.edc.database.di

import android.content.Context
import androidx.room.Room
import com.edc.database.CoffeeNoteDataBase
import com.edc.database.dao.CoffeeNoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestModule {
    @Provides
    @Singleton
    @Named("test_coffee_note_dao")
    fun providesTestCoffeeNoteDao(
        @ApplicationContext context: Context
    ): CoffeeNoteDao =
        Room.inMemoryDatabaseBuilder(
            context = context,
            klass = CoffeeNoteDataBase::class.java,
        ).build().coffeeNoteDao()
}