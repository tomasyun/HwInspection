package com.yinghuo.highway.ui.labourer.salary

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import javax.inject.Inject

class EmploySalaryViewPagerAdapter @Inject constructor(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {
    
    private var index: Int = 0
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> SalaryDetailFragment()
        1 -> SalaryDeclareFragment()
        else -> SalaryDetailFragment()
    }

    override fun getCount(): Int = index

    fun setCount(index: Int) {
        this.index = index
    }
}