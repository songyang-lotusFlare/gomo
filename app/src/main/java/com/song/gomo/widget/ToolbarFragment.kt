package com.song.gomo.widget

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.song.gomo.R
import com.song.gomo.databinding.ToolbarMainBinding
import com.song.gomo.ui.base.BaseFragment
import q.rorbin.badgeview.Badge
import q.rorbin.badgeview.QBadgeView

open class ToolbarFragment : BaseFragment() {

    private lateinit var qBadgeView: Badge
//    protected lateinit var toolbarBinding: ToolbarMainBinding
    protected var toolbarRootView: View? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    protected fun setToolbarBackListener(click: () -> Unit) {
        toolbarRootView?.let {
            it.findViewById<ImageView>(R.id.toolbar_back).setOnClickListener {
            Log.d("hynl", "click: toolbar 222")
            click.invoke()
        }  }

//        toolbarBinding.toolbarBack.setOnClickListener {
//
//        }
    }

    protected fun setMainSubToolbarTitle(mainTitle: String, subTitle: String) {
//        val doubleGroup = toolbarBinding.groupDoubleTitle
//        val singleGroup = toolbarBinding.groupDoubleTitle
//        val mTitle = toolbarBinding.toolbarMainTitle
//        val sTitle = toolbarBinding.toolbarSubTitle
        toolbarRootView?.let {
            val doubleGroup: Group = it.findViewById(R.id.group_double_title)
            val singleGroup: Group = it.findViewById(R.id.group_single_title)
            val mTitle: TextView = it.findViewById(R.id.toolbar_main_title)
            val sTitle: TextView = it.findViewById(R.id.toolbar_sub_title)


            if (TextUtils.isEmpty(mainTitle) && TextUtils.isEmpty(subTitle)) {
                doubleGroup.visibility = View.GONE
                doubleGroup.visibility = View.GONE
                singleGroup.visibility = View.GONE
            } else if (TextUtils.isEmpty(mainTitle) || TextUtils.isEmpty(subTitle)) {
                doubleGroup.visibility = View.GONE
                setToolbarTitle(if (TextUtils.isEmpty(mainTitle)) subTitle else mainTitle )
            } else {
                singleGroup.visibility = View.GONE
                doubleGroup.visibility = View.VISIBLE
                mTitle.text = mainTitle
                sTitle.text = subTitle
            }
        }

    }


    protected fun setToolbarTitle(title: String) {
        toolbarRootView?.let {
            val doubleGroup: Group = it.findViewById(R.id.group_double_title)
            val singleGroup: Group = it.findViewById(R.id.group_single_title)
            val tTitle: TextView = it.findViewById(R.id.toolbar_title)

            if (TextUtils.isEmpty(title)) {
                tTitle.visibility = View.GONE
            } else {
                singleGroup.visibility = View.VISIBLE
                doubleGroup.visibility = View.GONE
                tTitle.text = title
            }
        }

    }

    // rightmost icon or only icon
    protected fun setToolbarIcon(resId: Int, click: ()-> Unit) {
        toolbarRootView?.let {
            val icon: ImageView = it.findViewById(R.id.toolbar_img_rightmost)

            icon.visibility = View.VISIBLE
            icon.setOnClickListener {
                click.invoke()
            }
            // if need badge, can do ...
            qBadgeView = QBadgeView(context).setBadgeGravity(Gravity.END or Gravity.TOP)
                .bindTarget(icon)
        }


    }

    // second icon
    protected fun setMultiToolbarIcon(resIdRightmost: Int,clickOne: ()-> Unit, resIdSub: Int, clickTwo: () -> Unit) {
        toolbarRootView?.let {
            val iconRightmost: ImageView = it.findViewById(R.id.toolbar_img_rightmost)
            iconRightmost.visibility = View.VISIBLE
            val iconSub: ImageView = it.findViewById(R.id.toolbar_img_sub)
            iconSub.visibility = View.GONE
            iconRightmost.setImageResource(resIdRightmost)
            iconSub.setImageResource(resIdSub)
            iconRightmost.setOnClickListener {
                clickOne.invoke()
            }
            iconSub.setOnClickListener {
                clickTwo.invoke()
            }

            qBadgeView = QBadgeView(context).setBadgeGravity(Gravity.END or Gravity.TOP)
                .bindTarget(iconRightmost)
        }

    }

    override fun onBackPressed(): Boolean {
        findNavController().navigateUp()
        return true
    }
}