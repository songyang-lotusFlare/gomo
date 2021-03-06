package ph.com.globe.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ph.com.globe.data.db.profile_info.GomoUserDao
import ph.com.globe.data.db.profile_info.GomoUserEntity


@Database(entities = [GomoUserEntity::class], version = 0, exportSchema = false)
internal abstract class GomoDatabase : RoomDatabase() {
    abstract fun userDao(): GomoUserDao

    //todo :add more Dao ...

    companion object {
        const val NAME = "Globe.db"

        @Volatile
        private var instance: GomoDatabase? = null

        fun getInstance(context: Context): GomoDatabase {
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
