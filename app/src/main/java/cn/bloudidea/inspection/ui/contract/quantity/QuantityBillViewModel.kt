package cn.bloudidea.inspection.ui.contract.quantity

import cn.bloudidea.inspection.base.BaseViewModel
import javax.inject.Inject

class QuantityBillViewModel @Inject constructor() : BaseViewModel() {

    val data: MutableList<QuantityBillListItem> = ArrayList()

    init {
        initBills()
    }

    private fun initBills() {
        val item = QuantityBillListItem(
            quantityBillNo = "100",
            billName = "施工环保费",
            unit = "金额",
            contractCount = "200000",
            contractAccount = "200000",
            auditCount = "10",
            auditAccount = "12716899.38",
            parentBill = "100",
            levelType = "叶子节点"
        )

        for (i in 0 until 5) {
            data.add(item)
        }
    }
}