package com.yinghuo.highway.ui
import com.yinghuo.highway.base.BaseViewModel
import com.yinghuo.highway.data.prefs.AppPrefsHelper
import com.yinghuo.highway.util.RxTimerUtils
import javax.inject.Inject

class SplashViewModel @Inject internal constructor(private val appPrefsHelper: AppPrefsHelper) : BaseViewModel() {
    fun isLogin() = appPrefsHelper.getIsLogin()
}