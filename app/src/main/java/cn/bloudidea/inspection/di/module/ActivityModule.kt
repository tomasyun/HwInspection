package cn.bloudidea.inspection.di.module

import androidx.recyclerview.widget.LinearLayoutManager
import cn.bloudidea.inspection.base.BaseActivity
import cn.bloudidea.inspection.di.ActivityScope
import cn.bloudidea.inspection.ui.InspectListAdapter
import cn.bloudidea.inspection.ui.save.SaveStepDistanceViewPagerAdapter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: BaseActivity) {

    @Provides
    @ActivityScope
    fun provideActivity(): BaseActivity = activity

    @Provides
    fun provideInspectListAdapter(): InspectListAdapter = InspectListAdapter(activity, ArrayList())

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideSaveStepDistanceViewPagerAdapter(): SaveStepDistanceViewPagerAdapter =
        SaveStepDistanceViewPagerAdapter(activity.supportFragmentManager)

}