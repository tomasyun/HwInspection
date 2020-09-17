package com.yinghuo.highway.ui.labourer.employee

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import javax.inject.Inject

class EmployeeManageViewPagerAdapter @Inject constructor(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {
    private var tabIndex: Int = 0
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> EmployeeInfoFragment()
        1 -> EmployeeAttendanceFragment()
        2 -> EmployeeBlackListFragment()
        3 -> EmployeeWarningFragment()
        else -> EmployeeInfoFragment()
    }

    override fun getCount(): Int = tabIndex

    fun setCount(tabIndex: Int) {
        this.tabIndex = tabIndex
    }
}