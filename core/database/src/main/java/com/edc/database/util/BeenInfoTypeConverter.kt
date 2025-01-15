package com.edc.database.util

import androidx.room.TypeConverter
import com.edc.database.model.CoffeeBeenInfoEntity
import com.google.gson.Gson

internal class BeenInfoTypeConverter {
    @TypeConverter
    fun beenInfoEntityToJson(value: CoffeeBeenInfoEntity?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToBeenInfoEntity(value: String): CoffeeBeenInfoEntity? {
        return Gson().fromJson(value, CoffeeBeenInfoEntity::class.java)
    }
}