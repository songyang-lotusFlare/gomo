package com.song.module

import com.song.module.profile.repo.INetworkGomoProfileService

interface INetworkManagers {

    fun getProfileNetworkRepo(): INetworkGomoProfileService
}