package com.yinghuo.highway.ui.cost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_meterage_manage.*
import javax.inject.Inject

class MeterageManageFragment : BaseFragment() {
    @Inject
    lateinit var pgAdapter: MeterageManageViewPagerAdapter
    private lateinit var tabs: MutableList<TabLayout.Tab>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_meterage_manage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabs = ArrayList<TabLayout.Tab>();
        tabs.add(tbMeterageManage.newTab().setText("合同计量"))
        tabs.add(tbMeterageManage.newTab().setText("变更计量"))
        tabs.add(tbMeterageManage.newTab().setText("材料计量"))
        tabs.add(tbMeterageManage.newTab().setText("暂定金计量"))
        tabs.add(tbMeterageManage.newTab().setText("汇总报审"))
        tabs.add(tbMeterageManage.newTab().setText("计日工计量"))
        tabs.add(tbMeterageManage.newTab().setText("总包报表"))
        for (i in 0 until tabs.size) {
            tbMeterageManage.addTab(tabs[i])
        }
        tbMeterageManage.tabMode = TabLayout.MODE_SCROLLABLE
        pgAdapter.count = tabs.size;
        vpMeterageManage.adapter = pgAdapter
        vpMeterageManage.currentItem = 0;
        vpMeterageManage.offscreenPageLimit = tbMeterageManage.tabCount
        vpMeterageManage.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(tbMeterageManage)
        )
        tbMeterageManage.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                vpMeterageManage.currentItem = tab!!.position
            }
        })
    }
}