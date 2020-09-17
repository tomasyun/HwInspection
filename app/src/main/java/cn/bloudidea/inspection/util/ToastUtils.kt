package cn.bloudidea.inspection.util

import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.util.ViewUtils.dpToPx

class ToastUtils private constructor() {
    private val MARGIN_DP = 50
    private var toast: Toast? = null
    private val marginVertical = 50
    private fun cancel() {
        if (toast != null) {
            toast!!.cancel()
            toast = null
        }
    }

    fun showToastBottom(ctx: Context, resId: Int) {
        val msg = ctx.getString(resId)
        showToast(ctx, msg)
    }

    fun showToast(ctx: Context, msg: String?) {
        cancel()
        if (TextUtils.isEmpty(msg)) {
            return
        }
        showToastCustom(ctx, msg, R.layout.toast, R.id.txt_toast_message, R.color.white)
    }

    fun showToastCenter(ctx: Context, resId: Int) {
        val msg = ctx.getString(resId)
        showToastCenter(ctx, msg)
    }

    private fun showToastCenter(ctx: Context?, msg: String?) {
        cancel()
        if (TextUtils.isEmpty(msg)) {
            return
        }
        toast = Toast(ctx)
        toast!!.duration = Toast.LENGTH_SHORT
        toast!!.setGravity(Gravity.CENTER, 0, 0)
        //		toast.setText(msg);
        val layout = LinearLayout(ctx)
        val textView = TextView(ctx)
        textView.text = msg
        layout.addView(textView)
        toast!!.view = layout
        toast!!.show()
    }

    fun showToastCustom(
        ctx: Context,
        msg: String?,
        layoutResId: Int,
        txtResId: Int,
        txtColor: Int
    ) {
        showToastCustom(ctx, msg, layoutResId, txtResId, Gravity.BOTTOM, -1, txtColor)
    }

    private fun showToastCustom(
        ctx: Context,
        msg: String?,
        layoutResId: Int,
        txtResId: Int,
        gravity: Int,
        bgColor: Int,
        txtColor: Int
    ) {
        cancel()
        try {
            if (TextUtils.isEmpty(msg)) {
                return
            }
            val layout = LayoutInflater.from(ctx).inflate(layoutResId, null)
            if (bgColor > -1) {
                layout.setBackgroundColor(ctx.resources.getColor(bgColor))
            }
            val txtMsg = layout.findViewById<TextView>(txtResId)
            if (txtColor > -1) {
                txtMsg.setTextColor(ctx.resources.getColor(txtColor))
            }
            txtMsg.text = msg
            toast = Toast(ctx)
            toast!!.duration = Toast.LENGTH_SHORT
            toast!!.setGravity(gravity, 0, dpToPx(100f))
            //            if (gravity == Gravity.TOP) {
//                if (this.marginVertical == 0) {
//                    this.marginVertical = ViewUtils.dpToPx(MARGIN_DP);
//                }
//                toast.setGravity(gravity, 0, this.marginVertical);
//            } else if (gravity == Gravity.BOTTOM) {
//                if (this.marginVertical == 0) {
//                    this.marginVertical = ViewUtils.dpToPx(MARGIN_DP);
//                }
//                toast.setGravity(gravity, 0, -this.marginVertical);
//            } else {
//                toast.setGravity(gravity, 0, 0);
//            }
            toast!!.view = layout
            toast!!.show()
        } catch (e: Exception) {
        }
    }

    companion object {
        var instance: ToastUtils? = null
        fun instance(): ToastUtils? {
            if (instance == null) {
                instance = ToastUtils()
            }
            return instance
        }
    }
}