package ph.com.globe.gomo.ui.sharedelement

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ph.com.globe.gomo.data.model.entity.User
import ph.com.globe.gomo.data.repository.UserRepository
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