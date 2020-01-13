package cn.bloudidea.inspection.ui.contract.laborer

import cn.bloudidea.inspection.base.BaseViewModel
import javax.inject.Inject

class LaborerBillViewModel @Inject constructor() : BaseViewModel() {

    val data: MutableList<LaborerBillListItem> = ArrayList()

    init {
        initData()
    }

    private fun initData() {

        val item = LaborerBillListItem(
            laborerBillName = "挖掘机",
            laborerBillUnit = "台班",
            laborerBillPrice = "500",
            laborerBillLevelType = "叶子节点"
        )

        for (i in 0 until 5) {
            data.add(item)
        }
    }
}