package cn.bloudidea.inspection.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import com.gyf.barlibrary.ImmersionBar

class SplashActivity : BaseActivity() {

    //    var logined by Preference("logined", false)
    private val vm by lazy {
        getViewModel(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ImmersionBar.with(this)
            .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
            .statusBarColor(R.color.black)
            .init();
        if (vm.isLogin()) {
            handler.sendEmptyMessageDelayed(0, 3000)
        } else {
            handler.sendEmptyMessageDelayed(1, 3000)
        }
    }

    private val handler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg!!.what) {
                0 -> {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    this@SplashActivity.finish()
                }
                else -> {
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                    this@SplashActivity.finish()
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        ImmersionBar.with(this).destroy();
    }
}