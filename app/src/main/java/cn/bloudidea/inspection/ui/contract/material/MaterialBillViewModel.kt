package cn.bloudidea.inspection.ui.contract.material

import cn.bloudidea.inspection.base.BaseViewModel
import javax.inject.Inject

class MaterialBillViewModel @Inject constructor() : BaseViewModel() {

    val data: MutableList<MaterialBillListItem> = ArrayList()

    init {

    }

}