package cn.bloudidea.inspection.contract

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import kotlinx.android.synthetic.main.activity_acceptance.*
import kotlinx.android.synthetic.main.activity_contract_manager.*
import timber.log.Timber
import java.lang.ref.WeakReference

class ContractManagerActivity : BaseActivity() {
    private lateinit var navHostFragment: NavHostFragment;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("=====onCreate=====")
        setContentView(R.layout.activity_contract_manager)
        setSupportActionBar(tbAcceptance)
        supportActionBar?.title = ""
        tvContractManageTitle.text = "合同看板"
        contractManageDrawer.closeDrawer(contract_manage_navigation_view)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.contract_manage_nav_host_fragment) as NavHostFragment
        // NavigationUI.setupWithNavController(navigation_view, navHostFragment.navController)
        val weakReference = WeakReference(contract_manage_navigation_view);
        navHostFragment.navController.addOnDestinationChangedListener(object :
            NavController.OnDestinationChangedListener {
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                var view = weakReference.get();
                if (view == null) {
                    navHostFragment.navController.removeOnDestinationChangedListener(this);
                } else {
                    val menu = view.menu;
                    val h = 0;
                    for (index in h until menu.size()) {
                        val item = menu.getItem(h);
                        item.isChecked = matchDestination(destination, item.itemId);
                    }
                }
            }
        });

        val drawable = DrawerArrowDrawable(this);
        drawable.color = resources.getColor(R.color.bg_default)
        val mDrawerToggle = ActionBarDrawerToggle(
            this,
            contractManageDrawer,
            tbContractManage,
            R.string.open_drawer,
            R.string.close_drawer
        )
        mDrawerToggle.drawerArrowDrawable = drawable
        contractManageDrawer.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()
        contract_manage_navigation_view.setNavigationItemSelectedListener { p ->
            val handled = NavigationUI.onNavDestinationSelected(p, navHostFragment.navController);
            if (handled) {
                val parent = contract_manage_navigation_view.parent;
                if (parent is DrawerLayout) {
                    parent.closeDrawer(contract_manage_navigation_view);
                }
            }
            when (p.itemId) {
                R.id.contractBoard -> tvContractManageTitle.text = "合同看板"
                R.id.bidSection -> tvContractManageTitle.text = "标段概况"
                R.id.materialBill -> tvContractManageTitle.text = "材料清单"
                R.id.laborerBill -> tvContractManageTitle.text = "计日工清单"
                R.id.priceBill -> tvContractManageTitle.text = "价格清单"
                R.id.periodManage -> tvContractManageTitle.text = "计量工期管理"
                R.id.planProportionManage -> tvContractManageTitle.text = "计划比例管理"
                R.id.provisionalGoldManage -> tvContractManageTitle.text = "暂定金清单"
            }
            handled
        }
//        chart.loadUrl("file:///android_asset/test02.html")
//        val client: WebViewClient =
//            object : WebViewClient() {
//                override fun shouldOverrideUrlLoading(
//                    view: WebView,
//                    url: String
//                ): Boolean {
//                    view.loadUrl(url)
//                    return true
//                }
//
//                override fun onPageFinished(
//                    webView: WebView,
//                    s: String
//                ) {
//                    super.onPageFinished(webView, s)
////                  refreshLineChart()
//                    webView.loadUrl("javascript:createChart();")
//                }
//            }
//        chart.webViewClient = client
//    fun refreshLineChart() {
//        val x: Array<String?> = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
//        val y: Array<Int?> = arrayOf(820, 932, 901, 934, 1290, 1330, 1320)
//        refreshEchartsWithOption(EchartOption.getLineChartOptions(x, y));
//    }

        /**刷新图表
         * java调用js的loadEcharts方法刷新echart
         * 不能在第一时间就用此方法来显示图表，因为第一时间html的标签还未加载完成，不能获取到标签值
         * @param option
         */
//    private fun refreshEchartsWithOption(option: GsonOption?) {
//        if (option == null) {
//            return
//        }
//        val optionString = option.toString()
//        val call = "javascript:loadEcharts('$optionString')"
//        chart.loadUrl(call)
//    }
    }

    private fun matchDestination(destination: NavDestination, itemId: Int): Boolean {
        var currentDestination = destination;
        while (currentDestination.getId() != itemId && currentDestination.getParent() != null) {
            currentDestination = currentDestination.getParent()!!;
        }
        return currentDestination.getId() == itemId;
    }
}