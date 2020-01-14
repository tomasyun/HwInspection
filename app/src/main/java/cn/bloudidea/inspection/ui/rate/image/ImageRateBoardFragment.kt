package cn.bloudidea.inspection.ui.rate.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import kotlinx.android.synthetic.main.fragment_image_rate_manage.*

class ImageRateBoardFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_rate_manage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rateBoardView.loadUrl("file:///android_asset/bar.html")

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
                    webView.loadUrl("javascript:createBarLineChart();")
                    webView.loadUrl("javascript:createPieChart();")
                }
            }
        rateBoardView.webViewClient = client
    }
}