package com.yinghuo.highway.ui.contract.quantity

import android.os.Bundle
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_quantity_bill.*

class AddQuantityBillActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_quantity_bill)
        setSupportActionBar(tbAddQuantityBill)
        supportActionBar!!.title = ""
        tvAddQuantityBillTitle.text = "新增工程量清单"
        ivAddQuantityBill.setOnClickListener { finish() }
        addQuantityBillFab.setOnClickListener {}
    }
}