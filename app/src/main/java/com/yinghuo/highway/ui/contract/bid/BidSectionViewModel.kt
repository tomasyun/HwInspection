package com.yinghuo.highway.ui.contract.bid

import com.yinghuo.highway.base.BaseViewModel
import javax.inject.Inject

class BidSectionViewModel @Inject constructor() : BaseViewModel() {
    val data: MutableList<String> = ArrayList()

    init {
        data.add(0, "A01")
        data.add(1, "A02")
        data.add(2, "A03")
        data.add(3, "A04")
        data.add(4, "B01")
        data.add(5, "B02")
    }
}