package cn.bloudidea.inspection.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_message.*
import javax.inject.Inject

class MessageFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(MessageViewModel::class.java)
    }

    @Inject
    lateinit var pgAdapter: MsgViewPagerAdapter
    //    private var pos: Int = 0
    private lateinit var tabs: MutableList<TabLayout.Tab>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvMessageTitle.text = "消息"
        tabs = ArrayList()
        tabs.add(tbLayoutMessage.newTab().setText("未读"))
        tabs.add(tbLayoutMessage.newTab().setText("已读"))
//        tbLayoutMessage.tabMode=TabLayout.MODE_SCROLLABLE
        for (i in 0 until tabs.size) {
            tbLayoutMessage.addTab(tabs[i])
        }
//        pos = 0
        pgAdapter.count = tabs.size
        vpMessage.adapter = pgAdapter
        vpMessage.currentItem = 0
        vpMessage.offscreenPageLimit = tbLayoutMessage.tabCount
        vpMessage.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tbLayoutMessage))
//        vpMessage.setPageTransformer(true, DepthPageTransformer())
        tbLayoutMessage.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                vpMessage.currentItem = tab!!.position
//                pos = tab!!.position
            }
        })
    }
}