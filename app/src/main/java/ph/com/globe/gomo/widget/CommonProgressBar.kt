package ph.com.globe.gomo.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.wang.avi.AVLoadingIndicatorView
import ph.com.globe.gomo.R

/**
 * loading progress bar
 */

class CommonProgressBar(context: Context) : Dialog(context, R.style.CommonAlertDialogTheme) {
    private lateinit var mProgressBar: AVLoadingIndicatorView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_common_progress_bar)
        mProgressBar = findViewById(R.id.loading_bar)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    override fun show() {
        super.show()
        mProgressBar.show()
    }
}
