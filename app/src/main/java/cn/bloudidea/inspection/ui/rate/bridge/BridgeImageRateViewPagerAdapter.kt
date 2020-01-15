package cn.bloudidea.inspection.ui.rate.bridge

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import javax.inject.Inject

class BridgeImageRateViewPagerAdapter @Inject constructor(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private var tabIndex: Int = 0
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> BridgeRateReportFragment()
        1 -> BridgePlanFormulationFragment()
        else -> BridgeRateReportFragment()
    }

    override fun getCount(): Int = tabIndex

    fun setCount(index: Int) {
        tabIndex = index
    }
}