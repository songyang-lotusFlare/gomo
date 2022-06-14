package com.song.gomo.ui.shop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.song.gomo.R
import com.song.gomo.databinding.FragmentShopBinding
import com.song.gomo.databinding.ToolbarMainBinding
import com.song.gomo.widget.ToolbarFragment

class ShopIntroduceFragment: ToolbarFragment() {


    private lateinit var binding: FragmentShopBinding
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentShopBinding.inflate(inflater, container, false)
        toolbarBinding = binding.toolbar
        initView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initView() {

        setToolbarTitle(getString(R.string.title_shop))
        setToolbarBackListener {
            onBackPressed()
        }
        setMultiToolbarIcon(R.drawable.ic_menu_shop,
            {
                showShortToast(R.string.default_show)
            }, R.drawable.ic_menu_like,
            {
                showShortToast(R.string.default_show)
            })

    }

    override fun onBackPressed(): Boolean {
        return super.onBackPressed()
    }
}
