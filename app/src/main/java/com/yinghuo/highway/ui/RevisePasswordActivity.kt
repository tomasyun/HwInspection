package com.yinghuo.highway.ui

import android.os.Bundle
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import com.yinghuo.highway.util.ToastUtils
import kotlinx.android.synthetic.main.activity_revise_password.*

class RevisePasswordActivity : BaseActivity() {

    private val vm by lazy {
        getViewModel(RevisePasswordViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revise_password)
        setSupportActionBar(tbRevisePassword)
        supportActionBar?.title = ""
        tvRevisePasswordTitle.text = "修改密码"
        ivRevisePasswordBack.setOnClickListener { finish() }

        btnRevise.setOnClickListener {
            if (etPasswordOld.text.isNullOrEmpty()) {
                ToastUtils.instance()?.showToast(this, "原密码不能为空")
            } else if (etPasswordNew.text.isNullOrEmpty()) {
                ToastUtils.instance()?.showToast(this, "新密码不能为空")
            } else if (etPasswordAgain.text.isNullOrEmpty()) {
                ToastUtils.instance()?.showToast(this, "请再次输入新密码")
            } else if (etPasswordAgain.text != etPasswordNew.text) {
                ToastUtils.instance()?.showToast(this, "抱歉!两次密码不一致")
            } else {

            }
        }
    }
}