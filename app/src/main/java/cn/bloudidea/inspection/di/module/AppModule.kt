package cn.bloudidea.inspection.di.module

import android.app.Application
import androidx.room.Room
import cn.bloudidea.inspection.data.database.AppDatabase
import cn.bloudidea.inspection.data.database.AppDbHelper
import cn.bloudidea.inspection.data.database.DbHelper
import cn.bloudidea.inspection.data.prefs.AppPrefsHelper
import cn.bloudidea.inspection.data.prefs.PrefsHelper
import cn.bloudidea.inspection.di.AppScope
import cn.bloudidea.inspection.di.DatabaseInfo
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