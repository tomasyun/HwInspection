package cn.bloudidea.inspection.ui.labourer

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
import kotlinx.android.synthetic.main.activity_labourer_manage.*
import java.lang.ref.WeakReference

class LabourerManageActivity : BaseActivity() {
    private lateinit var navHostFragment: NavHostFragment;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_labourer_manage)
        setSupportActionBar(tbLabourerManage)
        supportActionBar?.title = ""
        tvLabourerManageTitle.text = "劳务管理"
        labourerManageDrawer.closeDrawer(labourer_manager_navigation_view)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.labourer_manager_nav_host_fragment) as NavHostFragment
        // NavigationUI.setupWithNavController(navigation_view, navHostFragment.navController)
        val weakReference = WeakReference(labourer_manager_navigation_view);
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
        drawable.color = resources.getColor(R.color.bg_default)
        val mDrawerToggle = ActionBarDrawerToggle(
            this,
            labourerManageDrawer,
            tbLabourerManage,
            R.string.open_drawer,
            R.string.close_drawer
        )
        mDrawerToggle.drawerArrowDrawable = drawable
        labourerManageDrawer.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()
        labourer_manager_navigation_view.setNavigationItemSelectedListener { p ->
            val handled = NavigationUI.onNavDestinationSelected(p, navHostFragment.navController);
            if (handled) {
                val parent = labourer_manager_navigation_view.parent;
                if (parent is DrawerLayout) {
                    parent.closeDrawer(labourer_manager_navigation_view);
                }
            }
            when (p.itemId) {
                R.id.employeeDataSource -> tvLabourerManageTitle.text = "数据看板"
                R.id.employeeManage -> tvLabourerManageTitle.text = "人员管理"
                R.id.employeeTraining -> tvLabourerManageTitle.text = "培训教育"
                R.id.employeePeccancy -> tvLabourerManageTitle.text = "违章管理"
                R.id.employeeBaseData -> tvLabourerManageTitle.text = "基础数据"
                R.id.employeeSalary -> tvLabourerManageTitle.text = "工资管理"
                R.id.employeeReportForm -> tvLabourerManageTitle.text = "报表管理"
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