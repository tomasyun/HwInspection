package com.yinghuo.highway.ui.rate.bridge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_bridge_image_rate.*
import javax.inject.Inject

class BridgeImageRateFragment : BaseFragment() {

    @Inject
    lateinit var pgAdapter: BridgeImageRateViewPagerAdapter

    private lateinit var tabs: MutableList<TabLayout.Tab>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bridge_image_rate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabs = ArrayList<TabLayout.Tab>();
        tabs.add(tbBridgeImageRate.newTab().setText("进度填报"))
        tabs.add(tbBridgeImageRate.newTab().setText("计划编制"))
        for (i in 0 until tabs.size) {
            tbBridgeImageRate.addTab(tabs[i])
        }
        pgAdapter.count = tabs.size;
        vpBridgeImageRate.adapter = pgAdapter
        vpBridgeImageRate.currentItem = 0;
        vpBridgeImageRate.offscreenPageLimit = tbBridgeImageRate.tabCount
        vpBridgeImageRate.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                tbBridgeImageRate
            )
        )
        tbBridgeImageRate.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                vpBridgeImageRate.currentItem = tab!!.position
            }
        })
    }
}