package com.song.module.profile.repo

import com.song.model.profile.domin_models.GomoUserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface IDataGomoProfileRepo {

    suspend fun getGomoUser(): Flow<GomoUserModel>

}