package com.yinghuo.highway.ui.message

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import javax.inject.Inject

class MsgViewPagerAdapter @Inject constructor(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {
    private var tabIndex: Int = 0

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> UnReadFragment()
        1 -> HasReadFragment()
        else -> UnReadFragment()
    }

    override fun getCount(): Int = tabIndex

    fun setCount(index: Int) {
        this.tabIndex = index
    }
}