package cn.bloudidea.inspection.ui

import android.os.Bundle
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import kotlinx.android.synthetic.main.activity_acceptance.*

class AcceptanceActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceptance)
        setSupportActionBar(tbAcceptance)
        supportActionBar?.title = ""
        tvAcceptanceTitle.text = "巡检验收"
        ivAcceptanceBack.setOnClickListener { finish() }
    }
}