package cn.bloudidea.inspection.data.prefs

interface PrefsHelper {

    fun getCurrentUserName(): String

    fun setCurrentUserName(userName: String?)

    fun getIsLogin(): Boolean

    fun setIsLogin(isLogin: Boolean)

}