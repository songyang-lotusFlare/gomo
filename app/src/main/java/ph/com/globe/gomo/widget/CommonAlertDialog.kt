package ph.com.globe.gomo.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import ph.com.globe.gomo.R


/**
 * Use with() function to create and show the CommonAlertDialog
 * Example:
 * with(CommonAlertDialog(context)) {
 *     setCanceledOnTouchOutside(true)
 *     setIcon()
 *     setTitle()
 *     show()
 * }
 * This CommonAlertDialog contains 5 parts: icon, title, content, left button and right button
 * A part only shows when you set the value of it. Otherwise it doesn't show
 */

open class CommonAlertDialog : Dialog {
    private var iconResId: Int? = null
    private var textTitle: String? = null
    private var textContent: String? = null
    private var textLeftButton: String? = null
    private var textRightButton: String? = null
    private var actionLeftButton: View.OnClickListener? = null
    open var actionRightButton: View.OnClickListener? = null

    open val layoutResId = R.layout.dialog_common

    constructor(context: Context) : super(context, R.style.CommonAlertDialogTheme)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initView())
    }

    open fun initView(view: View? = null): View {
        var viewParent: View = view ?: View.inflate(context, layoutResId, null)
        return viewParent.apply {
            val ivIcon = findViewById<ImageView>(R.id.iv_icon)
            val tvTitle = findViewById<TextView>(R.id.tv_title)
            val tvContent = findViewById<TextView>(R.id.tv_content)
            val btnLeft = findViewById<Button>(R.id.btn_left)
            val btnRight = findViewById<Button>(R.id.btn_right)

            iconResId?.let {
                ivIcon.visibility = View.VISIBLE
                val resId: Int = iconResId!!
                ivIcon.setImageResource(resId)
            }
            textTitle?.let {
                tvTitle.visibility = View.VISIBLE
                tvTitle.text = textTitle
            }
            textContent?.let {
                tvContent.visibility = View.VISIBLE
                tvContent.text = textContent
            }

            textLeftButton?.let {
                btnLeft.visibility = View.VISIBLE
                btnLeft.text = textLeftButton
                btnLeft.setOnClickListener(actionLeftButton)
            }
            textRightButton?.let {
                btnRight.visibility = View.VISIBLE
                btnRight.text = textRightButton
                btnRight.setOnClickListener(actionRightButton)
            }
        }
    }

    fun setIcon(resId: Int) {
        iconResId = resId
    }

    fun setTitle(title: String) {
        textTitle = title
    }

    fun setContent(content: String) {
        textContent = content
    }

    fun setLeftButton(leftText: String) {
        textLeftButton = leftText
    }

    fun setRightButton(rightText: String) {
        textRightButton = rightText
    }

    fun setLeftButtonListener(listener: View.OnClickListener) {
        actionLeftButton = listener
    }

    open fun setRightButtonListener(listener: View.OnClickListener) {
        actionRightButton = listener
    }
}
