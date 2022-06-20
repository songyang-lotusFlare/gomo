package ph.com.globe.gomo.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ph.com.globe.gomo.data.model.entity.User

@Dao
interface UserDao {

    @Query("SELECT * from user")
    fun getUser(): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<User>)

//    @Update
//    suspend fun updateUser(user: User)
//
//    @Query("DELETE FROM user")
//    suspend fun deleteUser()
}