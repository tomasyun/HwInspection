package com.yinghuo.highway.ui.labourer.salary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_empolyee_salary.*
import javax.inject.Inject

class EmployeeSalaryFragment : BaseFragment() {
    @Inject
    lateinit var pgAdapter: EmploySalaryViewPagerAdapter
    private lateinit var tabs: MutableList<TabLayout.Tab>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_empolyee_salary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabs = ArrayList()
        tabs.add(tbEmployeeSalary.newTab().setText("工资明细"))
        tabs.add(tbEmployeeSalary.newTab().setText("工资申报"))
//        tbLayoutMessage.tabMode=TabLayout.MODE_SCROLLABLE
        for (i in 0 until tabs.size) {
            tbEmployeeSalary.addTab(tabs[i])
        }
//        pos = 0
        pgAdapter.count = tabs.size
        vpEmployeeSalary.adapter = pgAdapter
        vpEmployeeSalary.currentItem = 0
        vpEmployeeSalary.offscreenPageLimit = tbEmployeeSalary.tabCount
//        vpEmployeeManage.setPageTransformer(true, DepthPageTransformer())
        vpEmployeeSalary.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                tbEmployeeSalary
            )
        )
        tbEmployeeSalary.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                vpEmployeeSalary.currentItem = tab!!.position
//                pos = tab!!.position
            }
        })
    }
}