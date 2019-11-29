package cn.bloudidea.inspection.di.module

import android.app.Activity
import androidx.recyclerview.widget.LinearLayoutManager
import cn.bloudidea.inspection.di.ActivityScope
import cn.bloudidea.inspection.ui.InspectListAdapter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    fun provideActivity(): Activity = activity

    @Provides
    fun provideInspectListAdapter(): InspectListAdapter = InspectListAdapter(activity, ArrayList())

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

}