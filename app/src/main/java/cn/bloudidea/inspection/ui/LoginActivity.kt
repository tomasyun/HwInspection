package cn.bloudidea.inspection.ui

import android.content.Intent
import android.os.Bundle
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import cn.bloudidea.inspection.util.ToastUtils
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