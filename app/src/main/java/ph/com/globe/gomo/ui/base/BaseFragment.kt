package ph.com.globe.gomo.ui.base

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import ph.com.globe.gomo.widget.CommonAlertDialog
import ph.com.globe.gomo.widget.CommonProgressBar


abstract class BaseFragment : Fragment() {

    private var mProgressBar: CommonProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("hynl", "onViewCreated: ${javaClass.simpleName}" )
        super.onViewCreated(view, savedInstanceState)
    }

    // toast
    fun showLongToast(text: String) {
        Toast.makeText(requireContext().applicationContext, text, Toast.LENGTH_LONG).show()
    }

    fun showShortToast(text: String) {
        Toast.makeText(requireContext().applicationContext, text, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(stringRes: Int) {
        showLongToast(resources.getString(stringRes))
    }

    fun showShortToast(stringRes: Int) {
        showShortToast(resources.getString(stringRes))
    }

    //progress
    fun showProgressBar() {
        if (mProgressBar == null) {
            mProgressBar = CommonProgressBar(requireContext())
        }
        if (mProgressBar != null && mProgressBar!!.isShowing.not()) {
            mProgressBar?.show()
        }
    }

    fun hideProgressBar() {
        if (this.isDetached) {
            mProgressBar = null
            return
        }
        if (mProgressBar?.isShowing == true && mProgressBar?.window?.windowManager != null) {
            mProgressBar?.dismiss()
            mProgressBar = null
        }
    }

    fun showCommonDialog(
        dialog: CommonAlertDialog,
        onTouchOutside: Boolean = false,
        title: String? = null,
        content: String? = null,
        rightBtnText: String? = null,
        leftBtnText: String? = null,
        rightBtnListener: View.OnClickListener? = null,
        leftBtnListener: View.OnClickListener? = null,
        icon: Int? = null
    ) {
        dialog.apply {
            rightBtnText?.let { setRightButton(it) }
            leftBtnListener?.let { setLeftButtonListener(it) }
            rightBtnListener?.let { setRightButtonListener(it) }
            rightBtnText?.let { setRightButton(it) }
            setCanceledOnTouchOutside(onTouchOutside)
            icon?.let { setIcon(it) }
            leftBtnText?.let { setLeftButton(it) }
            title?.let { setTitle(it) }
            content?.let { setContent(it) }
            show()
        }
    }


    open fun onBackPressed() : Boolean {
        return false
    }
}