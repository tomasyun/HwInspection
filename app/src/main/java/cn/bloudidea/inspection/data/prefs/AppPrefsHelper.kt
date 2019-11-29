package cn.bloudidea.inspection.data.prefs

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import cn.bloudidea.inspection.di.PreferenceInfo
import javax.inject.Inject

class AppPrefsHelper @Inject constructor(
    app: Application,
    @PreferenceInfo private val prefFileName: String
) :
    PrefsHelper {
    companion object {
        private val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private val PREF_KEY_IS_LOGIN = "PREF_KEY_IS_LOGIN"
    }

    private val mPrefs: SharedPreferences =
        app.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserName(): String = mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, "ABC")

    override fun setCurrentUserName(userName: String?) = mPrefs.edit {
        putString(
            PREF_KEY_CURRENT_USER_NAME, userName
        )
    }

    override fun getIsLogin(): Boolean = mPrefs.getBoolean(PREF_KEY_IS_LOGIN, false)

    override fun setIsLogin(isLogin: Boolean) = mPrefs.edit {
        putBoolean(PREF_KEY_IS_LOGIN, isLogin)
    }
}