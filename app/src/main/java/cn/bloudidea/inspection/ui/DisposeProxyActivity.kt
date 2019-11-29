package cn.bloudidea.inspection.ui

import android.os.Bundle
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import cn.bloudidea.inspection.util.ToastUtils
import kotlinx.android.synthetic.main.activity_dispose_proxy.*

class DisposeProxyActivity : BaseActivity() {
    private val vm by lazy { getViewModel(DisposeProxyViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dispose_proxy)
        setSupportActionBar(tbDisposeProxy)
        supportActionBar?.title = ""
        tvDisposeProxyTitle.text = "资源配置"
        ivDisposeProxyBack.setOnClickListener { finish() }

        btnDisposeProxy.setOnClickListener {
            if (etServiceIp.text.isNullOrEmpty()) {
                ToastUtils.Instance()?.showToast(this, "请输入服务器IP")
            } else if (etPort.text.isNullOrEmpty()) {
                ToastUtils.Instance()?.showToast(this, "请输入端口号")
            } else if (etPackageName.text.isNullOrEmpty()) {
                ToastUtils.Instance()?.showToast(this, "请输入应用名称")
            } else {
                
            }
        }
    }
}