package com.yinghuo.highway.util

import com.github.abel533.echarts.axis.CategoryAxis
import com.github.abel533.echarts.axis.ValueAxis
import com.github.abel533.echarts.code.Trigger
import com.github.abel533.echarts.json.GsonOption
import com.github.abel533.echarts.series.Line

object EChartsOption {
    fun getLineChartOptions(
        xAxis: Array<String?>,
        yAxis: Array<Int?>
    ): GsonOption {
        val option = GsonOption()
        option.title("折线图")
        option.legend("销量")
        option.tooltip().trigger(Trigger.axis)
        val valueAxis =
            ValueAxis()
        option.yAxis(valueAxis)
        val categoryAxis =
            CategoryAxis()
        categoryAxis.axisLine().onZero(false)
        categoryAxis.boundaryGap(true)
        categoryAxis.data(*xAxis)
        option.xAxis(categoryAxis)
        val line = Line()
        line.smooth(false).name("销量").data(*yAxis).itemStyle().normal().lineStyle()
            .shadowColor("rgba(0,0,0,0.4)")
        option.series(line)
        return option
    }
}