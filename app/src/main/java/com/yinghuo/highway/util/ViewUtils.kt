package com.yinghuo.highway.util

import android.content.Context
import android.content.res.Resources

object ViewUtils {
    @JvmStatic
    fun dpToPx(dp: Float): Int {
        val density =
            Resources.getSystem().displayMetrics.density
        return Math.round(dp * density)
    }

    fun pxToDp(px: Float): Float {
        val densityDpi =
            Resources.getSystem().displayMetrics.densityDpi.toFloat()
        return px / (densityDpi / 160f)
    }

    /**
     * convert px to its equivalent sp
     * 将px转换为sp
     */
    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    /**
     * convert sp to its equivalent px
     * 将sp转换为px
     */
    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}