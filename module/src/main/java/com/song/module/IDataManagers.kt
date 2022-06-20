package com.song.module

import com.song.module.profile.repo.IDataGomoProfileRepo

interface IDataManagers {

    fun getGomoUserDataRepo(): IDataGomoProfileRepo
}