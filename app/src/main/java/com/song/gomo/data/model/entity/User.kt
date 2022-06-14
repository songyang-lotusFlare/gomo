package com.song.gomo.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = User.TABLE_NAME)
@TypeConverters(UserConverters::class)
data class User (
    @PrimaryKey
    val _id : Int,
    val name : String,
    val password : String){
    companion object {
        const val TABLE_NAME = "user"
    }

    fun clone(): User {
        return this.copy()
    }
}
