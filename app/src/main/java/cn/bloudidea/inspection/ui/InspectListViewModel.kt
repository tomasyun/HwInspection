package cn.bloudidea.inspection.ui

import cn.bloudidea.inspection.base.BaseViewModel
import javax.inject.Inject

class InspectListViewModel @Inject constructor() : BaseViewModel() {

    //{"name":"12月份月度综合安全检查","status":"已完成","level":"一般","date":"2019-12-23 14:55"}

    val daily: MutableList<InspectListItem> = ArrayList()
    val expert: MutableList<InspectListItem> = ArrayList()
    val self: MutableList<InspectListItem> = ArrayList()

    init {
        initDaily()
        initExpert()
        initSelf()
    }

    private fun initDaily() {
        val item = InspectListItem(
            name = "12月份月度综合安全检查",
            status = "已完成",
            level = "一般",
            date = "2019-12-23 14:55"
        )

        for (i in 0 until 10) {
            daily.add(item)
        }
    }

    private fun initExpert() {
        val item =
            InspectListItem(
                name = "月度综合安全检查",
                status = "整改中",
                level = "严重",
                date = "2019-12-06 09:32"
            )
        for (i in 0 until 10) {
            expert.add(item)
        }
    }

    private fun initSelf() {
        val item = InspectListItem(
            name = "日常巡检",
            status = "已完成",
            level = "一般",
            date = "2019-12-23 14:55"
        )
        for (i in 0 until 10) {
            self.add(item)
        }
    }
}