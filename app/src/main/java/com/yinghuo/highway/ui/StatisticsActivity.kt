package com.yinghuo.highway.ui

import android.os.Bundle
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import com.yinghuo.highway.util.support.EasyStateView
import kotlinx.android.synthetic.main.activity_statistics.*

class StatisticsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
        setSupportActionBar(tbStatistics)
        supportActionBar?.title = ""
        tvStatisticsTitle.text = "检查统计"
        ivStatisticsBack.setOnClickListener { finish() }
        statisticStateView.showViewState(EasyStateView.VIEW_EMPTY)
    }
}