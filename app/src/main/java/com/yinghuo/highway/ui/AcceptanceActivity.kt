package com.yinghuo.highway.ui

import android.os.Bundle
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import com.yinghuo.highway.util.support.EasyStateView
import kotlinx.android.synthetic.main.activity_acceptance.*

class AcceptanceActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceptance)
        setSupportActionBar(tbAcceptance)
        supportActionBar?.title = ""
        tvAcceptanceTitle.text = "巡检验收"
        ivAcceptanceBack.setOnClickListener { finish() }
        acceptanceStateView.showViewState(EasyStateView.VIEW_EMPTY)
    }
}