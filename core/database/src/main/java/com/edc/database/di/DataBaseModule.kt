package com.edc.database.di

import android.content.Context
import androidx.room.Room
import com.edc.database.CoffeeNoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun providesCoffeeNoteDataBase(
        @ApplicationContext context: Context,
    ): CoffeeNoteDataBase = Room.databaseBuilder(
        context,
        CoffeeNoteDataBase::class.java,
        "coffee-note-database",
    ).build()
}