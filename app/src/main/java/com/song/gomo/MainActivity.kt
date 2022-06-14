package com.song.gomo

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationBarView.LABEL_VISIBILITY_LABELED
import com.song.gomo.databinding.ActivityMainBinding
import com.song.gomo.ui.base.BaseActivity
import com.song.gomo.ui.sharedelement.UserViewModel
import com.song.gomo.widget.CommonAlertDialog
import com.song.gomo.utils.HandleBackUtil
import com.song.gomo.utils.applicationViewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicBoolean

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navHostFragment: Fragment? = null

    private var keepOnScreen = AtomicBoolean(true)
    private lateinit var splashScreen: SplashScreen
    private var isInitReady = false
    private lateinit var badgeTip : BadgeDrawable


    private val userViewModel : UserViewModel by applicationViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
        binding.root.viewTreeObserver.addOnPreDrawListener (object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                return if (isInitReady) {
                    //monitor background tasks completed
                    binding.root.viewTreeObserver.removeOnPreDrawListener(this)
                    true
                }else{
                    false
                }
            }
        })

        // when fragment changed, judge bottomNavigationView show or hide
        navController.addOnDestinationChangedListener { _, destination, _ ->

            when {
                destination.label!!.contains("login") -> {
                    navView.visibility = View.GONE
                }
                destination.label!!.contains("shopIntroduce") -> {
                    navView.visibility = View.GONE
                }
                else -> {
                    navView.visibility = View.VISIBLE
                }
            }
        }

        with(navView) {
            labelVisibilityMode = LABEL_VISIBILITY_LABELED
            itemTextAppearanceActive
            setOnItemReselectedListener{
            //execute reselected  like: refresh

            }

            setOnItemSelectedListener {
            //
                return@setOnItemSelectedListener true
            }
        }

        // Navigate next fragment & init background Sth
        executeBackgroundTask(navController)
        navView.setupWithNavController(navController)
    }



    private fun executeBackgroundTask(navController : NavController) {
        lifecycleScope.launch {
            delay(2000)
            keepOnScreen.compareAndSet(true, false)
        }
        //when finish ! set true
        isInitReady = true
        splashScreen.setKeepOnScreenCondition {
            keepOnScreen.get()
        }
        //test to nav
        if(userViewModel.getCurrentStatus()) {
            navController.navigate(R.id.login)
        } else {
            navController.navigate(R.id.navigation_home)
        }
    }

    override fun onBackPressed() {
        if (!HandleBackUtil.handleBackPress(navHostFragment?.childFragmentManager)) {
            with(CommonAlertDialog(this)) {
                setCanceledOnTouchOutside(false)
                setTitle(getString(R.string.title_prompt))
                setContent(getString(R.string.exit))
                setLeftButton(getString(R.string.no))
                setRightButton(getString(R.string.yes))
                setLeftButtonListener(View.OnClickListener { dismiss() })
                setRightButtonListener(View.OnClickListener {
                    super.onBackPressed()
                    dismiss()
                    finish()
                })
                show()
                //UiUtil.adjustDialogGravity(this, context)
            }
        }
    }
}