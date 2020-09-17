package cn.bloudidea.inspection.ui.contract

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
import kotlinx.android.synthetic.main.activity_contract_manage.*
import timber.log.Timber
import java.lang.ref.WeakReference

class ContractManagerActivity : BaseActivity() {
    private lateinit var navHostFragment: NavHostFragment;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("=====onCreate=====")
        setContentView(R.layout.activity_contract_manage)
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
        drawable.color = resources.getColor(R.color.white)
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
                R.id.quantityBill -> tvContractManageTitle.text = "工程量清单"
                R.id.materialBill -> tvContractManageTitle.text = "材料清单"
                R.id.laborerBill -> tvContractManageTitle.text = "计日工清单"
                R.id.priceBill -> tvContractManageTitle.text = "价格清单"
                R.id.periodManage -> tvContractManageTitle.text = "计量工期管理"
                R.id.planProportionManage -> tvContractManageTitle.text = "计划比例管理"
                R.id.provisionalGoldManage -> tvContractManageTitle.text = "暂定金清单"
            }
            handled
        }
    }

    private fun matchDestination(destination: NavDestination, itemId: Int): Boolean {
        var currentDestination = destination;
        while (currentDestination.id != itemId && currentDestination.parent != null) {
            currentDestination = currentDestination.parent!!;
        }
        return currentDestination.id == itemId;
    }
}