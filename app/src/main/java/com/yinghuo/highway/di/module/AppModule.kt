package com.yinghuo.highway.di.module

import android.app.Application
import androidx.room.Room
import com.yinghuo.highway.data.database.AppDatabase
import com.yinghuo.highway.data.database.AppDbHelper
import com.yinghuo.highway.data.database.DbHelper
import com.yinghuo.highway.data.prefs.AppPrefsHelper
import com.yinghuo.highway.data.prefs.PrefsHelper
import com.yinghuo.highway.di.AppScope
import com.yinghuo.highway.di.DatabaseInfo
import com.yinghuo.highway.di.PreferenceInfo
import com.yinghuo.highway.di.component.ActivityComponent
import com.yinghuo.highway.di.component.FragmentComponent
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
    internal fun providePrefsName(): String = "hw_pref"

    @Provides
    @Singleton
    internal fun providePrefHelper(helper: AppPrefsHelper): PrefsHelper = helper

    @Provides
    @DatabaseInfo
    internal fun provideDataBaseName(): String = "hw_database"

    @Provides
    @Singleton
    internal fun provideAppDataBase(@DatabaseInfo dataBaseName: String): AppDatabase =
        Room.databaseBuilder(
            app.applicationContext,
            AppDatabase::class.java,
            dataBaseName
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    internal fun provideDbHelp(helper: AppDbHelper): DbHelper = helper
}