package ph.com.globe.gomo.utils

import android.net.Uri
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions

fun NavController.safeNavigate(@IdRes resId: Int) {
    try {
        navigate(resId)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun NavController.safeNavigate(@IdRes resId: Int, args: Bundle?) {
    try {
        navigate(resId, args)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun NavController.safeNavigate(deepLink: Uri) {
    try {
        navigate(deepLink)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun NavController.safeNavigate(deepLink: Uri, navOptions: NavOptions?) {
    try {
        navigate(deepLink, navOptions)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun NavController.safeNavigate(directions: NavDirections) {
    try {
        navigate(directions)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun NavController.safeNavigate(directions: NavDirections, navOptions: NavOptions?) {
    try {
        navigate(directions, navOptions)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
