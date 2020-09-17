package com.yinghuo.highway.di.module

import androidx.recyclerview.widget.LinearLayoutManager
import com.yinghuo.highway.base.BaseActivity
import com.yinghuo.highway.di.ActivityScope
import com.yinghuo.highway.ui.InspectListAdapter
import com.yinghuo.highway.ui.save.SaveStepDistanceViewPagerAdapter
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