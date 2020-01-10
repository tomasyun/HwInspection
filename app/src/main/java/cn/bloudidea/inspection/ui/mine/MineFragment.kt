package cn.bloudidea.inspection.ui.mine

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import cn.bloudidea.inspection.ui.DisposeProxyActivity
import cn.bloudidea.inspection.ui.RevisePasswordActivity
import cn.bloudidea.inspection.ui.SplashActivity
import cn.bloudidea.inspection.util.ToastUtils
import kotlinx.android.synthetic.main.fragment_mine.*
import org.jetbrains.anko.support.v4.alert

class MineFragment : BaseFragment(), View.OnClickListener {
    //    private var logined by Preference("logined", false)
    private val vm by lazy {
        getViewModel(MineViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvMineTitle.text = "我的"
        relRevisePassword.setOnClickListener(this)
        relSetUp.setOnClickListener(this)
        relSetting.setOnClickListener(this)
        relUpgrade.setOnClickListener(this)
        relLogOut.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.relSetUp -> startActivity(Intent(activity, DisposeProxyActivity::class.java))
            R.id.relRevisePassword -> startActivity(
                Intent(
                    activity,
                    RevisePasswordActivity::class.java
                )
            )
            R.id.relSetting -> {
                ToastUtils.instance()?.showToast(activity!!, "暂未开放")
//                startActivity(Intent(activity, SettingActivity::class.java))
            }
            R.id.relUpgrade -> ToastUtils.instance()?.showToast(activity!!, "当前最新版本")
            R.id.relLogOut -> logout()
        }
    }

    private fun logout() {
        alert("确定退出登录?") {
            title = "提示"
            positiveButton("确定") {
                startActivity(Intent(activity, SplashActivity::class.java))
                activity?.finish()
//                logined = false
                vm.isLogin()
            }
            negativeButton("取消") {

            }
        }.show()
    }
}