package com.yinghuo.highway.ui.cost

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import javax.inject.Inject

class MeterageManageViewPagerAdapter @Inject constructor(manager: FragmentManager) :
    FragmentStatePagerAdapter(manager) {
    private var index = 0
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> ContractMeterageFragment()
        1 -> AlterMeterageFragment()
        2 -> MaterialMeterageFragment()
        3 -> ProvisionalGoldMeterageFragment()
        4 -> SummaryReportFragment()
        5 -> LabourerMeterageFragment()
        6 -> EPCReportFormFragment()
        else -> ContractMeterageFragment()
    }

    override fun getCount(): Int = index


    fun setCount(index: Int) {
        this.index = index
    }
}