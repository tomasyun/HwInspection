package com.yinghuo.highway.ui.save

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import kotlinx.android.synthetic.main.activity_save_step_distance.*
import javax.inject.Inject

class SaveStepDistanceActivity : BaseActivity() {

    @Inject
    lateinit var pgAdapter: SaveStepDistanceViewPagerAdapter
    private lateinit var tabs: MutableList<TabLayout.Tab>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_step_distance)
        setSupportActionBar(tbSaveStepDistance)
        supportActionBar!!.title = ""
        tvSaveStepDistanceTitle.text = "安全步距"
        ivSaveStepDistanceBack.setOnClickListener { finish() }
        tabs = ArrayList()
        tabs.add(tbLayoutSaveStepDistance.newTab().setText("实时监控"))
        tabs.add(tbLayoutSaveStepDistance.newTab().setText("超标信息"))
        tabs.add(tbLayoutSaveStepDistance.newTab().setText("历史数据"))
//        tbLayoutMessage.tabMode=TabLayout.MODE_SCROLLABLE
        for (i in 0 until tabs.size) {
            tbLayoutSaveStepDistance.addTab(tabs[i])
        }
//        pos = 0
        pgAdapter.count = tabs.size
        vpSaveStepDistance.adapter = pgAdapter
        vpSaveStepDistance.currentItem = 0
        vpSaveStepDistance.offscreenPageLimit = tbLayoutSaveStepDistance.tabCount
        vpSaveStepDistance.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                tbLayoutSaveStepDistance
            )
        )
//        vpMessage.setPageTransformer(true, DepthPageTransformer())
        tbLayoutSaveStepDistance.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                vpSaveStepDistance.currentItem = tab!!.position
//                pos = tab!!.position
            }
        })
    }
}