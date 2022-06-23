package ph.com.globe.data.db.profile_info

import androidx.room.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Dao
internal interface GomoUserDao {

    @Query("SELECT * from gomo_user")
    fun getUser(): Flow<GomoUserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: GomoUserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<GomoUserEntity>)

    @Query("DELETE FROM gomo_user")
    suspend fun deleteUser()
}

//Dao query class
internal class GomoUserQueryDao @Inject constructor(
    private val gomoUserDao: GomoUserDao
) {
    suspend fun clearAndInsert(user: GomoUserEntity) {
        withContext(Dispatchers.IO) {
            gomoUserDao.deleteUser()
            gomoUserDao.insertUser(user)
        }
    }

    fun getAllUser(): Flow<GomoUserEntity> =
        gomoUserDao.getUser()

    suspend fun deleteAllUser() = gomoUserDao.deleteUser()
}


