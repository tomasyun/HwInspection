package com.yinghuo.highway.ui.save

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_realtime_monitor.*

class RealTimeMonitorFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_realtime_monitor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        realTimeMonitorStateView.showViewState(EasyStateView.VIEW_EMPTY)
        monitorView.loadUrl("file:///android_asset/gauge.html")
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
        monitorView.webViewClient = client
    }
}