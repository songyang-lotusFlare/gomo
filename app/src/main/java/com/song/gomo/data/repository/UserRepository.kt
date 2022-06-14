package com.song.gomo.data.repository

import androidx.lifecycle.LiveData
import com.song.gomo.data.database.UserDao
import com.song.gomo.data.datastore.PreferencesDataStore
import com.song.gomo.data.model.entity.User
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