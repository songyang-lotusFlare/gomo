package com.song.gomo.data.model.entity

import androidx.room.TypeConverter
import com.google.gson.Gson


class UserConverters {
    @TypeConverter
    fun listToString(list: List<String>?): String? {
        return list?.joinToString("+")
    }

    @TypeConverter
    fun stringToList(value: String?): List<String>? {
        return value?.split("+")
    }

}