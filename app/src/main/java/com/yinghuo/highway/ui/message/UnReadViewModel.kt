package com.yinghuo.highway.ui.message
import com.yinghuo.highway.base.BaseViewModel
import javax.inject.Inject

class UnReadViewModel @Inject constructor() : BaseViewModel() {
    val data: MutableList<MessageListItem> = ArrayList()

    init {
        initAction()
    }

    private fun initAction() {
        val item = MessageListItem(title = "施工单位全面自检", date = "2019-12-31 13:45:36", sender = "王俊")
//        for (i in 0 until 10) {
//            data.add(item)
//        }
    }
}