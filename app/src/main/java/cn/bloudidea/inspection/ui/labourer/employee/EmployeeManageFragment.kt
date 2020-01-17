package cn.bloudidea.inspection.ui.labourer.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_employee_manage.*
import javax.inject.Inject

class EmployeeManageFragment : BaseFragment() {

    @Inject
    lateinit var pgAdapter: EmployeeManageViewPagerAdapter
    private lateinit var tabs: MutableList<TabLayout.Tab>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employee_manage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabs = ArrayList()
        tabs.add(tbEmployeeManage.newTab().setText("人员信息"))
        tabs.add(tbEmployeeManage.newTab().setText("人员考勤"))
        tabs.add(tbEmployeeManage.newTab().setText("黑名单"))
        tabs.add(tbEmployeeManage.newTab().setText("人员预警"))
//        tbLayoutMessage.tabMode=TabLayout.MODE_SCROLLABLE
        for (i in 0 until tabs.size) {
            tbEmployeeManage.addTab(tabs[i])
        }
//        pos = 0
        pgAdapter.count = tabs.size
        vpEmployeeManage.adapter = pgAdapter
        vpEmployeeManage.currentItem = 0
        vpEmployeeManage.offscreenPageLimit = tbEmployeeManage.tabCount
//        vpEmployeeManage.setPageTransformer(true, DepthPageTransformer())
        vpEmployeeManage.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                tbEmployeeManage
            )
        )
        tbEmployeeManage.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                vpEmployeeManage.currentItem = tab!!.position
//                pos = tab!!.position
            }
        })
    }
}