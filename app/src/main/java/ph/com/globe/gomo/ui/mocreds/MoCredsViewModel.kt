package ph.com.globe.gomo.ui.mocreds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoCredsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mo Creds Fragment"
    }
    val text: LiveData<String> = _text
}