package com.yinghuo.highway.ui.save

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import javax.inject.Inject

class SaveStepDistanceViewPagerAdapter @Inject constructor(
    manager: FragmentManager
) : FragmentStatePagerAdapter(manager) {
    private var index = 0
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> RealTimeMonitorFragment()
        1 -> ExceedStandardInfoFragment()
        2 -> HistoryRecordFragment()
        else -> RealTimeMonitorFragment()
    }

    override fun getCount(): Int = index

    fun setCount(index: Int) {
        this.index = index
    }
}