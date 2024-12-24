package com.edc.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.edc.database.dao.CoffeeNoteDao
import com.edc.database.model.CoffeeNoteEntity
import com.edc.database.util.BeenInfoTypeConverter
import com.edc.database.util.BrewingStepListTypeConverter

@Database(
    entities = [CoffeeNoteEntity::class],
    version = 1
)
@TypeConverters(
    value = [BrewingStepListTypeConverter::class, BeenInfoTypeConverter::class]
)
internal abstract class CoffeeNoteDataBase : RoomDatabase() {
    abstract fun coffeeNoteDao(): CoffeeNoteDao
}