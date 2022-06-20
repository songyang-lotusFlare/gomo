package com.song.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.song.data.db.profile_info.GomoUserDao

@Database(entities = [GomoUserDao::class], version = 0, exportSchema = false)
abstract class GomoDatabase : RoomDatabase(){

    abstract fun userDao(): GomoUserDao

    //todo :add more Dao ...


    companion object {
        const val NAME = "Globe.db"

        @Volatile private var instance : GomoDatabase? = null

        fun getInstance(context : Context) : GomoDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): GomoDatabase {
            return Room.databaseBuilder(context, GomoDatabase::class.java, NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}