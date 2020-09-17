package com.yinghuo.highway.ui.mine

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gyf.barlibrary.ImmersionBar
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import com.yinghuo.highway.ui.RevisePasswordActivity
import com.yinghuo.highway.ui.SplashActivity
import com.yinghuo.highway.util.ToastUtils
import kotlinx.android.synthetic.main.fragment_mine.*
import org.jetbrains.anko.support.v4.alert

class MineFragment : BaseFragment(), View.OnClickListener {
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
        ImmersionBar.with(this)
            .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
            .statusBarColor(R.color.colorPrimary)
            .init();
        tvMineTitle.text = "我的"
        relRevisePassword.setOnClickListener(this)
        relSetUp.setOnClickListener(this)
        relSetting.setOnClickListener(this)
        relUpgrade.setOnClickListener(this)
        relLogOut.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.relRevisePassword -> startActivity(
                Intent(
                    activity,
                    RevisePasswordActivity::class.java
                )
            )
            R.id.relSetting -> {
                ToastUtils.instance()?.showToast(activity!!, "暂未开放")
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
                vm.isLogin()
            }
            negativeButton("取消") {

            }
        }.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        ImmersionBar.with(this).destroy();
    }
}