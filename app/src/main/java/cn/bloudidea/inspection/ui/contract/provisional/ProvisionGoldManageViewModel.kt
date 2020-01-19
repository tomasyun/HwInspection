package cn.bloudidea.inspection.ui.contract.provisional

import cn.bloudidea.inspection.base.BaseViewModel
import javax.inject.Inject

class ProvisionGoldManageViewModel @Inject constructor() : BaseViewModel() {

    val data: MutableList<ProvisionGoldManageListItem> = ArrayList()

    init {
        initData()
    }

    private fun initData() {
        val item = ProvisionGoldManageListItem(
            provisionGoldNo = "zdj-001",
            provisionGoldName = "暂定金001",
            provisionGoldContractCount = "100",
            provisionGoldContractAccount = "100000",
            provisionGoldUnit = "元"
        )

        for (i in 0 until 15) {
            data.add(item)
        }
    }
}