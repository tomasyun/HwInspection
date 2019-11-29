package cn.bloudidea.inspection.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import kotlinx.android.synthetic.main.activity_select.*

class SelectActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        setSupportActionBar(tbSelect)
        supportActionBar?.title = ""
        when (intent.extras.get("skip")) {
            0 -> {
                tvSelectTitle.text = "检查标段"
                tvSelectContent.text = "通风兼安全洞、进场交通洞施工工程"
            }
            1 -> {
                tvSelectTitle.text = "责任单位"
                tvSelectContent.text = "xxxxxx有限公司"
            }
            2 -> {
                tvSelectTitle.text = "检查类型"
                tvSelectContent.text = "日常检查"
            }
            3 -> {
                tvSelectTitle.text = "通知人"
                tvSelectContent.text = "张善"
            }
        }
        ivSelectBack.setOnClickListener { finish() }

        tvSelectContent.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().putExtra("value", tvSelectContent.text))
            finish()
        }
    }
}