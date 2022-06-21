package ph.com.globe.gomo.ui.sharedelement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ph.com.globe.gomo.data.repository.UserRepository
import javax.inject.Inject

class UserViewModelFactory @Inject constructor(private val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}
