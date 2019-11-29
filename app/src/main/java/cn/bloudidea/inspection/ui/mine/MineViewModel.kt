package cn.bloudidea.inspection.ui.mine

import cn.bloudidea.inspection.base.BaseViewModel
import cn.bloudidea.inspection.data.prefs.AppPrefsHelper
import javax.inject.Inject

class MineViewModel @Inject constructor(private val appPrefsHelper: AppPrefsHelper) :
    BaseViewModel() {

    fun isLogin() = appPrefsHelper.setIsLogin(false)
}