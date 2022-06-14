package com.song.gomo

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.song.gomo.ui.sharedelement.UserViewModelFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class GomoApplication : Application(), ViewModelStoreOwner {

    private var viewModelStore : ViewModelStore? = null

    @Inject
    lateinit var userViewModelFactory: UserViewModelFactory


    fun getDefaultFactory(): ViewModelProvider.Factory {
        return userViewModelFactory
    }

    override fun getViewModelStore(): ViewModelStore {
        if(viewModelStore == null) {
            viewModelStore = ViewModelStore()
        }
        return viewModelStore as ViewModelStore
    }
}