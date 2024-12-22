package com.edc.database.util

import androidx.room.TypeConverter
import com.edc.database.model.BrewingStepEntity
import com.google.gson.Gson

internal class BrewingStepListTypeConverter {
    @TypeConverter
    fun listToJson(value: List<BrewingStepEntity>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<BrewingStepEntity>? {
        return Gson().fromJson(value, Array<BrewingStepEntity>::class.java)?.toList()
    }
}