package com.yinghuo.highway.ui

import android.content.Intent
import android.os.Bundle
import com.gyf.barlibrary.ImmersionBar
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import com.yinghuo.highway.util.RxTimerUtils
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import timber.log.Timber

class SplashActivity : BaseActivity() {
    private val vm by lazy {
        getViewModel(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ImmersionBar.with(this)
            .fitsSystemWindows(true)
            .statusBarColor(R.color.black)
            .init()
        Timber.i("登录状态为 %s", vm.isLogin())
        if (vm.isLogin()) {
            RxTimerUtils.timer(
                { tvCountDNum.text = String.format("%s", it.toInt()) },
                {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    this@SplashActivity.finish()
                }, 1, 5
            )
        } else {
            RxTimerUtils.timer({ tvCountDNum.text = String.format("%s", it.toInt()) }, {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                this@SplashActivity.finish()
            }, 1, 5)
        }
        skipBtn.onClick {
            RxTimerUtils.cancel()
            if (vm.isLogin()) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                this@SplashActivity.finish()
            } else {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                this@SplashActivity.finish()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ImmersionBar.with(this).destroy();
    }
}