package cn.bloudidea.inspection.ui

import cn.bloudidea.inspection.base.BaseViewModel
import cn.bloudidea.inspection.data.prefs.AppPrefsHelper
import javax.inject.Inject

class LoginViewModel @Inject internal constructor(private val appPrefsHelper: AppPrefsHelper) :
    BaseViewModel() {

    fun isLogin() = appPrefsHelper.setIsLogin(true)
}