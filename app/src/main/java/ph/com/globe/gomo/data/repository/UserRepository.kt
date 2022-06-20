package ph.com.globe.gomo.data.repository

import androidx.lifecycle.LiveData
import ph.com.globe.gomo.data.database.UserDao
import ph.com.globe.gomo.data.datastore.PreferencesDataStore
import ph.com.globe.gomo.data.model.entity.User

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDao : UserDao,
    private val dataStore: PreferencesDataStore
) {

    fun getUser() : LiveData<User>{
        return userDao.getUser()
    }
    suspend fun setUser(user : User) {
        userDao.insertUser(user)
    }

}