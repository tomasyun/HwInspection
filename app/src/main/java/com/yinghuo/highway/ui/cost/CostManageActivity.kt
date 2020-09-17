package com.yinghuo.highway.ui.cost

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import kotlinx.android.synthetic.main.activity_cost_manage.*
import java.lang.ref.WeakReference

class CostManageActivity : BaseActivity() {
    private lateinit var navHostFragment: NavHostFragment;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cost_manage)
        setSupportActionBar(tbCostManage)
        supportActionBar?.title = ""
        tvCostManageTitle.text = "费用管理"

        costManageDrawer.closeDrawer(cost_manager_navigation_view)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.cost_manager_nav_host_fragment) as NavHostFragment
        val weakReference = WeakReference(cost_manager_navigation_view);
        navHostFragment.navController.addOnDestinationChangedListener(object :
            NavController.OnDestinationChangedListener {
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                val view = weakReference.get();
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
            costManageDrawer,
            tbCostManage,
            R.string.open_drawer,
            R.string.close_drawer
        )
        mDrawerToggle.drawerArrowDrawable = drawable
        costManageDrawer.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()
        cost_manager_navigation_view.setNavigationItemSelectedListener { p ->
            val handled = NavigationUI.onNavDestinationSelected(p, navHostFragment.navController);
            if (handled) {
                val parent = cost_manager_navigation_view.parent;
                if (parent is DrawerLayout) {
                    parent.closeDrawer(cost_manager_navigation_view);
                }
            }
            when (p.itemId) {
                R.id.costDataBoard -> tvCostManageTitle.text = "数据看板"
                R.id.costAlterManage -> tvCostManageTitle.text = "变更管理"
                R.id.meterageManage -> tvCostManageTitle.text = "计量管理"
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