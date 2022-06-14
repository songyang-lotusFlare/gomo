package com.song.gomo.ui.sharedelement

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.song.gomo.data.model.entity.User
import com.song.gomo.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor (
    userRepository: UserRepository
) : ViewModel() {

    private var status = false

    val user : LiveData<User> = userRepository.getUser()

    fun getCurrentStatus() : Boolean {
        status = !status
        return status
    }

    fun checkGomoNumber() : Boolean {
        return true
    }

}