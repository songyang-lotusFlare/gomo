package com.song.data.network

import com.song.data.network.profile.GomoProfileService
import javax.inject.Inject

class NetworkServices @Inject constructor(

    private val profileManager: GomoProfileService) {

    fun getProfileNetworkRepo(): GomoProfileService = profileManager
}