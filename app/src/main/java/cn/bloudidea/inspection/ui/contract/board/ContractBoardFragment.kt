package cn.bloudidea.inspection.ui.contract.board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import cn.bloudidea.inspection.util.EChartsOption
import com.github.abel533.echarts.json.GsonOption
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import kotlinx.android.synthetic.main.fragment_contract_board.*

class ContractBoardFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contract_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        boardView.loadUrl("file:///android_asset/test02.html")
        val client: WebViewClient =
            object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    url: String
                ): Boolean {
                    view.loadUrl(url)
                    return true
                }

                override fun onPageFinished(
                    webView: WebView,
                    s: String
                ) {
                    super.onPageFinished(webView, s)
//                    refreshLineChart()
                    webView.loadUrl("javascript:createChart();")
                }
            }
        boardView.webViewClient = client
    }

    fun refreshLineChart() {
        val x: Array<String?> = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        val y: Array<Int?> = arrayOf(820, 932, 901, 934, 1290, 1330, 1320)
        refreshEChartsWithOption(EChartsOption.getLineChartOptions(x, y));
    }

    /**刷新图表
     * java调用js的loadEcharts方法刷新echart
     * 不能在第一时间就用此方法来显示图表，因为第一时间html的标签还未加载完成，不能获取到标签值
     * @param option
     */
    private fun refreshEChartsWithOption(option: GsonOption?) {
        if (option == null) {
            return
        }
        val optionString = option.toString()
        val call = "javascript:loadEcharts('$optionString')"
        boardView.loadUrl(call)
    }
}