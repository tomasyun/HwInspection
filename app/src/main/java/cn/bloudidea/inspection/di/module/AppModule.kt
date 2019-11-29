package cn.bloudidea.inspection.di.module

import android.app.Application
import cn.bloudidea.inspection.data.prefs.AppPrefsHelper
import cn.bloudidea.inspection.data.prefs.PrefsHelper
import cn.bloudidea.inspection.di.AppScope
import cn.bloudidea.inspection.di.PreferenceInfo
import cn.bloudidea.inspection.di.component.ActivityComponent
import cn.bloudidea.inspection.di.component.FragmentComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        ActivityComponent::class,
        FragmentComponent::class
    ]
)
class AppModule(private val app: Application) {

    @Provides
    @AppScope
    fun provideApp(): Application = app

    @Provides
    @PreferenceInfo
    internal fun providerPrefsName(): String = "hw_pref"

    @Provides
    @Singleton
    internal fun providePrefHelper(helper: AppPrefsHelper): PrefsHelper = helper
}