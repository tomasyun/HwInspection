package com.yinghuo.highway.ui

import android.content.Intent
import android.os.Bundle
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import com.yinghuo.highway.util.ToastUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    private val vm by lazy {
        getViewModel(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            when {
                etAccount?.text.isNullOrEmpty() -> {
                    ToastUtils.instance()?.showToast(this@LoginActivity, "用户名不能为空")
                }
                etPassword?.text.isNullOrEmpty() -> {
                    ToastUtils.instance()?.showToast(this@LoginActivity, "密码不能为空")
                }
                else -> {
                    vm.isLogin()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    this@LoginActivity.finish()
                }
            }
        }
    }
}