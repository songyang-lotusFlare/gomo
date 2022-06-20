package com.song.data.network

import com.song.module.INetworkManagers
import com.song.module.profile.repo.INetworkGomoProfileService
import javax.inject.Inject

class NetworkServices @Inject constructor(
    private val profileManager: INetworkGomoProfileService) : INetworkManagers{

    override fun getProfileNetworkRepo(): INetworkGomoProfileService = profileManager
}