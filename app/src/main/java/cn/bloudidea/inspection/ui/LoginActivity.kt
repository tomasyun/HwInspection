package cn.bloudidea.inspection.ui

import android.content.Intent
import android.os.Bundle
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import cn.bloudidea.inspection.util.ToastUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

//    var logined by Preference("logined", false)

    private val vm by lazy {
        getViewModel(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener {
            when {
                etAccount?.text.isNullOrEmpty() -> {
                    //toast("账号不能为空")
                    ToastUtils.instance()?.showToast(this, "密码不能为空")
                }
                etPassword?.text.isNullOrEmpty() -> {
                    ToastUtils.instance()?.showToast(this, "密码不能为空")
                }
                else -> {
                    // val sp=this.getSharedPreferences("inspect",0)
                    // sp.edit().putBoolean("login",true).apply()

                    //logined = true
                    vm.isLogin()
                    startActivity(Intent(this, MainActivity::class.java))
                    this.finish()
                }
            }
        }

        setUp.setOnClickListener { startActivity(Intent(this, DisposeProxyActivity::class.java)) }
    }
}