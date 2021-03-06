package ph.com.globe.gomo.ui.base

import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import androidx.navigation.fragment.findNavController
import ph.com.globe.gomo.databinding.ToolbarMainBinding
import q.rorbin.badgeview.Badge
import q.rorbin.badgeview.QBadgeView

open class ToolbarFragment : BaseFragment() {
    private lateinit var qBadgeView: Badge
    protected lateinit var toolbarBinding: ToolbarMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    protected fun setToolbarBackListener(click: () -> Unit) {
        toolbarBinding.toolbarBack.setOnClickListener {
            click.invoke()
        }
    }

    protected fun setMainSubToolbarTitle(mainTitle: String, subTitle: String) {
        with(toolbarBinding) {
            if (TextUtils.isEmpty(mainTitle) && TextUtils.isEmpty(subTitle)) {
                groupDoubleTitle.visibility = View.GONE
                groupDoubleTitle.visibility = View.GONE
                groupSingleTitle.visibility = View.GONE
            } else if (TextUtils.isEmpty(mainTitle) || TextUtils.isEmpty(subTitle)) {
                groupDoubleTitle.visibility = View.GONE
                setToolbarTitle(if (TextUtils.isEmpty(mainTitle)) subTitle else mainTitle)
            } else {
                groupSingleTitle.visibility = View.GONE
                groupDoubleTitle.visibility = View.VISIBLE
                toolbarMainTitle.text = mainTitle
                toolbarSubTitle.text = subTitle
            }
        }
    }

    protected fun setToolbarTitle(title: String) {
        with(toolbarBinding) {
            if (TextUtils.isEmpty(title)) {
                toolbarTitle.visibility = View.GONE
            } else {
                groupSingleTitle.visibility = View.VISIBLE
                groupDoubleTitle.visibility = View.GONE
                toolbarTitle.text = title
            }
        }
    }

    // rightmost icon or only icon
    protected fun setToolbarIcon(resId: Int, click: () -> Unit) {
        toolbarBinding.toolbarImgRightmost.visibility = View.VISIBLE
        toolbarBinding.toolbarImgRightmost.setOnClickListener {
            click.invoke()
        }
        // if need badge, can do ...
        qBadgeView = QBadgeView(context).setBadgeGravity(Gravity.END or Gravity.TOP)
            .bindTarget(toolbarBinding.toolbarImgRightmost)
    }

    /**
     * second one
     * TODO: update params to the significant name
     */
    protected fun setMultiToolbarIcon(
        resIdRightmost: Int,
        clickOne: () -> Unit,
        resIdSub: Int,
        clickTwo: () -> Unit
    ) {
        with(toolbarBinding) {
            toolbarImgRightmost.visibility = View.VISIBLE
            toolbarImgSub.visibility = View.VISIBLE
            toolbarImgRightmost.setImageResource(resIdRightmost)
            toolbarImgSub.setImageResource(resIdSub)
            toolbarImgRightmost.setOnClickListener {
                clickOne.invoke()
            }
            toolbarImgSub.setOnClickListener {
                clickTwo.invoke()
            }
        }
    }

    override fun onBackPressed(): Boolean {
        return findNavController().navigateUp()
    }
}
