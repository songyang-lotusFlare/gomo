package ph.com.globe.gomo.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ph.com.globe.gomo.R
import ph.com.globe.gomo.databinding.FragmentLoginBinding
import ph.com.globe.gomo.ui.base.BaseFragment
import ph.com.globe.gomo.ui.sharedelement.UserViewModel
import ph.com.globe.gomo.utils.PatternUtil
import ph.com.globe.gomo.utils.applicationViewModels
import ph.com.globe.gomo.utils.safeNavigate
import ph.com.globe.module.profile.ProfileModuleManager
import java.util.regex.Pattern
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    val userViewModel: UserViewModel by applicationViewModels()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var profileModuleManager: ProfileModuleManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        Log.d("hynl", "initView: ${profileModuleManager}")
        binding.btnLoginGo.setOnClickListener {
            if (!Pattern.matches(PatternUtil.REGEX_G_NO, binding.etLoginInput.text.toString())) {
                //toast
                showShortToast(R.string.login_error_toast_mismatch)
            } else {
                //match : navigation
                findNavController().safeNavigate(R.id.action_global_home)
            }
        }

        binding.cardShop.setOnClickListener {
            findNavController().safeNavigate(R.id.action_loginFragment_to_shopIntroduceFragment)
        }
    }
}
