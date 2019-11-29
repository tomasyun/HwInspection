package cn.bloudidea.inspection.ui

import android.os.Bundle
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import kotlinx.android.synthetic.main.activity_inspect_info.*

class InspectInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspect_info)
        setSupportActionBar(tbInspectInfo)
        supportActionBar?.title = ""
        tvInspectInfoTitle.text = "信息详情"
        ivInspectInfoBack.setOnClickListener { finish() }
    }
}