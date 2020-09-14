package cn.bloudidea.inspection.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import cn.bloudidea.inspection.util.GifSizeFilter
import cn.bloudidea.inspection.util.ToastUtils
import com.bumptech.glide.Glide
import com.tbruyelle.rxpermissions2.RxPermissions
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine
import com.zhihu.matisse.filter.Filter
import com.zhihu.matisse.internal.entity.CaptureStrategy
import com.zhihu.matisse.listener.OnCheckedListener
import com.zhihu.matisse.listener.OnSelectedListener
import kotlinx.android.synthetic.main.activity_add_inspect.*
import kotlinx.android.synthetic.main.activity_inspect_list.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor

class AddInspectActivity : BaseActivity() {
    private val vm by lazy {
        getViewModel(AddInspectViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_inspect)
        setSupportActionBar(tbInspectList)
        supportActionBar?.title = ""
        tvAddInspectTitle.text = "新增检查"
        ivAddInspectBack.setOnClickListener { finish() }

        ivAddAttachment.setOnClickListener { aboutPermission() }
        relSection.setOnClickListener {
            startActivityForResult(
                Intent(
                    this,
                    SelectActivity::class.java
                ).putExtra("skip", 0), 0
            )
        }
        relOrganization.setOnClickListener {
            startActivityForResult(
                Intent(
                    this,
                    SelectActivity::class.java
                ).putExtra("skip", 1), 1
            )
        }
        relType.setOnClickListener {
            startActivityForResult(
                Intent(
                    this,
                    SelectActivity::class.java
                ).putExtra("skip", 2), 2
            )
        }
        tvYiBan.setOnClickListener {
            tvYiBan.text = "一般"
            tvYiBan.textColor = Color.parseColor("#ffffff")
            tvYiBan.backgroundColor = Color.parseColor("#ffcc0000")
            tvSerious.text = "严重"
            tvSerious.textColor = Color.parseColor("#333333")
            tvSerious.backgroundColor = Color.parseColor("#f5f5f5")
        }
        tvSerious.setOnClickListener {
            tvYiBan.text = "一般"
            tvYiBan.textColor = Color.parseColor("#333333")
            tvYiBan.backgroundColor = Color.parseColor("#f5f5f5")
            tvSerious.text = "严重"
            tvSerious.textColor = Color.parseColor("#ffffff")
            tvSerious.backgroundColor = Color.parseColor("#ffcc0000")
        }
        relNoticeUser.setOnClickListener {
            startActivityForResult(
                Intent(
                    this,
                    SelectActivity::class.java
                ).putExtra("skip", 3), 3
            )
        }
        tvSave.setOnClickListener { }
        tvSubmit.setOnClickListener { }
        tvDelete.setOnClickListener { }
    }

    @SuppressLint("AutoDispose", "CheckResult")
    fun aboutPermission() {
        val permission = RxPermissions(this)
        permission.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe {
            if (it) {
                startAction()
            } else {
                ToastUtils.instance()?.showToast(this, "权限被拒绝")
            }
        }
    }

    private fun startAction() {
        Matisse.from(this)
            .choose(MimeType.ofImage(), false)
            .countable(true)
            .capture(true)
            .captureStrategy(
                CaptureStrategy(true, "cn.bloudidea.inspection.fileprovider", "test")
            )
            .maxSelectable(9)
            .addFilter(GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
            .gridExpectedSize(
                resources.getDimensionPixelSize(R.dimen.grid_expected_size)
            )
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            .thumbnailScale(0.85f)
            .imageEngine(GlideEngine())
            .setOnSelectedListener { _: MutableList<Uri>, _: MutableList<String> -> OnSelectedListener { _, _ -> } }
            .showSingleMediaType(true)
            .originalEnable(true)
            .maxOriginalSize(10)
            .autoHideToolbarOnSingleTap(true)
            .setOnCheckedListener { OnCheckedListener { _ -> } }
            .forResult(23);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            //List<Uri> uris=Matisse.obtainResult(data)
            //List<String> paths=Matisse.obtainPathResult(data)
            //ToastUtils.Instance()?.showToast(this, Matisse.obtainPathResult(data)[0])

//            Picasso.get().load(Matisse.obtainPathResult(data)[0]).centerCrop().fit()
//                .into(ivAddAttachment)
            when (requestCode) {
                23 -> Glide.with(this).load(Matisse.obtainResult(data)[0]).into(ivAddAttachment)
                0 -> tvSectionValue.text = data?.extras?.getString("value")
                1 -> tvOrganizationValue.text = data?.extras?.getString("value")
                2 -> tvTypeValue.text = data?.extras?.getString("value")
                3 -> tvNoticeUserValue.text = data?.extras?.getString("value")
            }
        }
    }
}