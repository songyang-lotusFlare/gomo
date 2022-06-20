package com.song.data.db.di

import com.song.data.db.profile_info.GomoUserDataRepository
import javax.inject.Inject

class RepositoryManager @Inject constructor(
    private val gomoUserRepository: GomoUserDataRepository
    //todo: add more Dao
){

    fun getGomoUserDataRepo(): GomoUserDataRepository = gomoUserRepository
}