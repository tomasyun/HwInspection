package com.yinghuo.highway.ui.labourer.report

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import com.yinghuo.highway.ui.FilePreviewActivity
import com.yinghuo.highway.util.ToastUtils
import kotlinx.android.synthetic.main.fragment_employee_report_form.*

class EmployeeReportFormFragment : BaseFragment() {
    private val fileName by lazy {
        "出租车信息.xlsx"
    }
    private val fileUrl by lazy {
        "http://39.106.93.223/出租车信息.xlsx"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employee_report_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachmentPreview.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    activity!!,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    activity!!,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                );
            } else {
                FilePreviewActivity.actionStart(activity!!, fileUrl = fileUrl, fileName = fileName)
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    FilePreviewActivity.actionStart(activity!!, fileUrl, fileName)
                } else {
                    ToastUtils.instance()!!.showToast(activity!!, "你拒绝了权限申请，可能无法下载文件到本地哟")
                }
            }
        }
    }
}