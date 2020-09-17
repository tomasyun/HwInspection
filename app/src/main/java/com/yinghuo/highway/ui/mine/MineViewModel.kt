package com.yinghuo.highway.ui.mine

import com.yinghuo.highway.base.BaseViewModel
import com.yinghuo.highway.data.prefs.AppPrefsHelper
import javax.inject.Inject

class MineViewModel @Inject constructor(private val appPrefsHelper: AppPrefsHelper) :
    BaseViewModel() {

    fun isLogin() = appPrefsHelper.setIsLogin(false)
}