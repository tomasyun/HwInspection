package cn.bloudidea.inspection.ui.message

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MsgViewPagerAdapter(fragmentManager: FragmentManager) :
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