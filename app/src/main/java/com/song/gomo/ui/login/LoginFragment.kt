package com.song.gomo.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.song.gomo.R
import com.song.gomo.databinding.FragmentLoginBinding
import com.song.gomo.ui.base.BaseFragment
import com.song.gomo.ui.sharedelement.UserViewModel
import com.song.gomo.utils.PatternUtil
import com.song.gomo.utils.applicationViewModels
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment() {


    val userViewModel : UserViewModel by applicationViewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        initView()
        return binding.root
    }

    fun initView() {
        binding.btnLoginGo.setOnClickListener {
            if(!Pattern.matches(PatternUtil.REGEX_G_NO, binding.etLoginInput.text.toString())) {
                //toast
                showShortToast(R.string.login_error_toast_mismatch)

            } else {
                //match : navigation
                findNavController().navigate(R.id.action_global_home)
            }
        }
        binding.cardShop.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_shopIntroduceFragment)
        }
    }

}