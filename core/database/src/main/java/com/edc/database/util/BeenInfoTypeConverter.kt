package com.edc.database.util

import androidx.room.TypeConverter
import com.edc.database.model.BeenInfoEntity
import com.google.gson.Gson

internal class BeenInfoTypeConverter {
    @TypeConverter
    fun beenInfoEntityToJson(value: BeenInfoEntity?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToBeenInfoEntity(value: String): BeenInfoEntity? {
        return Gson().fromJson(value, BeenInfoEntity::class.java)
    }
}