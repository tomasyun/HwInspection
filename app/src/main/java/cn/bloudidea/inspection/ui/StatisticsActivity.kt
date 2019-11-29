package cn.bloudidea.inspection.ui

import android.os.Bundle
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import kotlinx.android.synthetic.main.activity_statistics.*

class StatisticsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
        setSupportActionBar(tbStatistics)
        supportActionBar?.title = ""
        tvStatisticsTitle.text = "检查统计"
        ivStatisticsBack.setOnClickListener { finish() }
    }
}