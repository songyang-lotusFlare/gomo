package ph.com.globe.gomo

import android.os.Bundle
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
import com.google.android.material.navigation.NavigationBarView.LABEL_VISIBILITY_LABELED
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import ph.com.globe.gomo.databinding.ActivityMainBinding
import ph.com.globe.gomo.ui.base.BaseActivity
import ph.com.globe.gomo.ui.sharedelement.UserViewModel
import ph.com.globe.gomo.utils.HandleBackUtil
import ph.com.globe.gomo.utils.applicationViewModels
import ph.com.globe.gomo.utils.safeNavigate
import ph.com.globe.gomo.widget.CommonAlertDialog
import java.util.concurrent.atomic.AtomicBoolean

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private var navHostFragment: Fragment? = null

    private var keepOnScreen = AtomicBoolean(true)
    private lateinit var splashScreen: SplashScreen
    private var isInitReady = false

    private val userViewModel: UserViewModel by applicationViewModels()

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
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
        binding.root.viewTreeObserver.addOnPreDrawListener(object :
            ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                return if (isInitReady) {
                    //monitor background tasks completed
                    binding.root.viewTreeObserver.removeOnPreDrawListener(this)
                    true
                } else {
                    false
                }
            }
        })

        // when fragment changed, judge bottomNavigationView show or hide
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when {
                destination.label?.contains("login") == true -> {
                    navView.visibility = View.GONE
                }
                destination.label?.contains("shopIntroduce") == true -> {
                    navView.visibility = View.GONE
                }
                else -> {
                    navView.visibility = View.VISIBLE
                }
            }
        }

        with(navView) {
            labelVisibilityMode = LABEL_VISIBILITY_LABELED

            setOnItemReselectedListener {
                //execute reselected, like: refresh

            }

            setOnItemSelectedListener {
                return@setOnItemSelectedListener true
            }

            setupWithNavController(navController)
        }

        // Navigate next fragment & init background Sth
        executeBackgroundTask(navController)
    }

    /**
     *  mock the navigation
     */
    private fun executeBackgroundTask(navController: NavController) {
        lifecycleScope.launch {
            delay(2000)
            keepOnScreen.compareAndSet(true, false)
        }

        //when finish set the isInitReady is true
        isInitReady = true
        splashScreen.setKeepOnScreenCondition {
            keepOnScreen.get()
        }

        //test to nav
        if (userViewModel.getCurrentStatus()) {
            navController.safeNavigate(R.id.login)
        } else {
            navController.safeNavigate(R.id.navigation_home)
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
                setLeftButtonListener { dismiss() }
                setRightButtonListener {
                    super.onBackPressed()
                    dismiss()
                    finish()
                }
                show()
            }
        }
    }
}
