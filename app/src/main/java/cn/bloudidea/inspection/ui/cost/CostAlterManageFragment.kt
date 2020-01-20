package cn.bloudidea.inspection.ui.cost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_cost_alter_manage.*
import javax.inject.Inject

class CostAlterManageFragment : BaseFragment() {

    @Inject
    lateinit var pgAdapter: CostAlterManageViewPagerAdapter
    private lateinit var tabs: MutableList<TabLayout.Tab>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cost_alter_manage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabs = ArrayList<TabLayout.Tab>();
        tabs.add(tbCostAlterManage.newTab().setText("变更通知"))
        tabs.add(tbCostAlterManage.newTab().setText("变更费用申请"))
        tabs.add(tbCostAlterManage.newTab().setText("变更令申请"))
        tabs.add(tbCostAlterManage.newTab().setText("变更报表"))
        for (i in 0 until tabs.size) {
            tbCostAlterManage.addTab(tabs[i])
        }
        tbCostAlterManage.tabMode = TabLayout.MODE_SCROLLABLE
        pgAdapter.count = tabs.size;
        vpCostAlterManage.adapter = pgAdapter
        vpCostAlterManage.currentItem = 0;
        vpCostAlterManage.offscreenPageLimit = tbCostAlterManage.tabCount
        vpCostAlterManage.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                tbCostAlterManage
            )
        )
        tbCostAlterManage.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                vpCostAlterManage.currentItem = tab!!.position
            }
        })
    }
}