package com.song.data.db.di

import com.song.data.db.profile_info.GomoUserDataRepository
import com.song.module.IDataManagers
import com.song.module.profile.repo.IDataGomoProfileRepo
import javax.inject.Inject

class RepositoryManager @Inject constructor(
    private val gomoUserRepository: IDataGomoProfileRepo
    //todo: add more Dao
):  IDataManagers{

    override fun getGomoUserDataRepo(): IDataGomoProfileRepo = gomoUserRepository
}