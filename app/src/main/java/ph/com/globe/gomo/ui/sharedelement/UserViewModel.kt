package ph.com.globe.gomo.ui.sharedelement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.common.fold
import ph.com.globe.domain.profile.ProfileDomainManager
import ph.com.globe.model.profile.domain_models.GomoUser
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor() : ViewModel() {
    private var status = false
    @Inject
    lateinit var profileDomainManager: ProfileDomainManager

    private val _gomoUser = MutableLiveData<GomoUser>()
    val gomoUser: LiveData<GomoUser> = _gomoUser

    private fun getGomoUser() = viewModelScope.launch {
        profileDomainManager.getGomoUser().collect {
            it.fold({
                it?.let { user -> _gomoUser.value = user }
            }, {
                if (it is GetGomoUserError.General)
                   //handle err
                    it
            })
        }
    }

    fun getCurrentStatus(): Boolean {
        status = !status
        return status
    }

    fun checkGomoNumber(): Boolean {
        return true
    }
}
