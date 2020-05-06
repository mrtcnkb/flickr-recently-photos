package com.mrtcnkb.recentphotos.util

import android.content.Context
import android.graphics.PorterDuff
import android.os.Build
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

/**
 * Created by MuratCan on 6.05.2020.
 */
object Functions {
    private var snackbar: Snackbar? = null
    fun showSnackBar(context: Context, view: View, color: Int) {
        snackbar = Snackbar.make(view, "Yükleniyor..", Snackbar.LENGTH_INDEFINITE)
        (snackbar?.view as Snackbar.SnackbarLayout).let { snackbarView ->
            val snackProgressBar = ProgressBar(context)
            snackProgressBar.indeterminateDrawable.setColorFilter(
                ContextCompat.getColor(context, android.R.color.white),
                PorterDuff.Mode.MULTIPLY
            )
            snackbarView.addView(snackProgressBar)
            (snackProgressBar.layoutParams as FrameLayout.LayoutParams).apply {
                gravity = Gravity.END
                height = FrameLayout.LayoutParams.WRAP_CONTENT
                width = FrameLayout.LayoutParams.MATCH_PARENT
            }
            snackbarView.setBackgroundColor(ContextCompat.getColor(context, color))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                snackbarView.elevation = 5f
            }
            snackbar?.show()
        }
    }

    fun dismissSnackBar() {
        snackbar?.run {
            if (isShown) {
                dismiss()
            }
        }
    }
}