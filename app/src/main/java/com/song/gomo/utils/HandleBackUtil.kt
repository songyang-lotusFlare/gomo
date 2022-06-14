package com.song.gomo.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.song.gomo.ui.base.BaseFragment

object HandleBackUtil {

    fun handleBackPress(fragmentManager: FragmentManager?): Boolean {
        fragmentManager?.let {
            val fragments = it.fragments
            for (i: Int in fragments.size - 1 downTo 0) {
                val child = fragments[i]
                if (isFragmentBackHandled(child as BaseFragment)) {
                    return true
                }
            }
        }
        return false
    }

    private fun isFragmentBackHandled(fragment: BaseFragment): Boolean {
        return fragment.isVisible
                && fragment.userVisibleHint
                && fragment.onBackPressed()
    }
}