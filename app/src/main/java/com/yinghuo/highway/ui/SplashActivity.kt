package com.yinghuo.highway.ui

import android.content.Intent
import android.os.Bundle
import com.gyf.barlibrary.ImmersionBar
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import com.yinghuo.highway.util.RxTimerUtils
import timber.log.Timber

class SplashActivity : BaseActivity() {
    private val vm by lazy {
        getViewModel(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R .layout.activity_splash)
        ImmersionBar.with(this)
            .fitsSystemWindows(true)
            .statusBarColor(R.color.black)
            .init()
        Timber.i("登录状态为 %s", vm.isLogin())
        if (vm.isLogin()) {
            RxTimerUtils.timer({
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                this@SplashActivity.finish()
            }, 3000)
        } else {
            RxTimerUtils.timer({
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                this@SplashActivity.finish()
            }, 3000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ImmersionBar.with(this).destroy();
    }
}