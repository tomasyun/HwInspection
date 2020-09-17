package com.yinghuo.highway.ui.contract.material

import com.yinghuo.highway.base.BaseViewModel
import javax.inject.Inject

class MaterialBillViewModel @Inject constructor() : BaseViewModel() {
    val data: MutableList<MaterialBillListItem> = ArrayList()

    init {
    }
}