package ph.com.globe.gomo.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import ph.com.globe.gomo.data.model.entity.User
import ph.com.globe.gomo.utils.DATABASE_NAME
import ph.com.globe.gomo.works.SeedDatabaseWorker


@Database(entities = [User::class], version = 0, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object {

        @Volatile private var instance : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
                                .setInputData(workDataOf("name" to "gomo"))
                                .build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                )
                .build()
        }
    }

}