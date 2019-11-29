package cn.bloudidea.inspection.ui

import android.os.Bundle
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : BaseActivity() {
    private val vm by lazy {
        getViewModel(SettingViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setSupportActionBar(tbSetting)
        supportActionBar?.title = ""
        tvSettingTitle.text = "设置"
        ivSettingBack.setOnClickListener { finish() }
    }
}