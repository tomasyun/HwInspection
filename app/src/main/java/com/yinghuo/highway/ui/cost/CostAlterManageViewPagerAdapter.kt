package com.yinghuo.highway.ui.cost

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import javax.inject.Inject

class CostAlterManageViewPagerAdapter @Inject constructor(manager: FragmentManager) :
    FragmentStatePagerAdapter(manager) {
    private var index = 0
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> AlterNotifyFragment()
        1 -> AlterCostApplyFragment()
        2 -> AlterCommandApplyFragment()
        3 -> AlterReportFormFragment()
        else -> AlterNotifyFragment()
    }

    override fun getCount(): Int = index

    fun setCount(index: Int) {
        this.index = index
    }
}