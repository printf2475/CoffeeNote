package com.edc.database.util

import androidx.room.TypeConverter
import com.edc.database.model.BrewingRecipeEntity
import com.google.gson.Gson

internal class BrewingRecipeListTypeConverter {
    @TypeConverter
    fun listToJson(value: List<BrewingRecipeEntity>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<BrewingRecipeEntity>? {
        return Gson().fromJson(value, Array<BrewingRecipeEntity>::class.java)?.toList()
    }
}