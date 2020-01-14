package cn.bloudidea.inspection.ui.rate

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
import kotlinx.android.synthetic.main.activity_rate_manage.*
import java.lang.ref.WeakReference

class RateManageActivity : BaseActivity() {
    private lateinit var navHostFragment: NavHostFragment;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_manage)
        setSupportActionBar(tbRateManage)
        supportActionBar?.title = ""
        tvRateManageTitle.text = "进度管理"

        rateManageDrawer.closeDrawer(rate_manage_navigation_view)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.rate_manage_nav_host_fragment) as NavHostFragment
        // NavigationUI.setupWithNavController(navigation_view, navHostFragment.navController)
        val weakReference = WeakReference(rate_manage_navigation_view);
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
            rateManageDrawer,
            tbRateManage,
            R.string.open_drawer,
            R.string.close_drawer
        )
        mDrawerToggle.drawerArrowDrawable = drawable
        rateManageDrawer.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()
        rate_manage_navigation_view.setNavigationItemSelectedListener { p ->
            val handled = NavigationUI.onNavDestinationSelected(p, navHostFragment.navController);
            if (handled) {
                val parent = rate_manage_navigation_view.parent;
                if (parent is DrawerLayout) {
                    parent.closeDrawer(rate_manage_navigation_view);
                }
            }
            when (p.itemId) {
                R.id.imageRateBroad -> tvRateManageTitle.text = "形象进度看板"
                R.id.bridgeRateBroad -> tvRateManageTitle.text = "桥梁进度看板"
                R.id.tunnelRateBroad -> tvRateManageTitle.text = "隧道进度看板"
                R.id.bridgeImageRate -> tvRateManageTitle.text = "桥梁形象进度"
                R.id.tunnelImageRate -> tvRateManageTitle.text = "隧道形象进度"
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