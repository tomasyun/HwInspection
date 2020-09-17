package com.yinghuo.highway.ui

import android.annotation.TargetApi
import android.app.AlertDialog
import android.app.DownloadManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.database.ContentObserver
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.tencent.smtt.sdk.TbsReaderView
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import com.yinghuo.highway.util.ToastUtils
import kotlinx.android.synthetic.main.activity_file_preview.*
import java.io.File
import java.text.DecimalFormat

class FilePreviewActivity : BaseActivity(), TbsReaderView.ReaderCallback {
    private var mTbsReaderView: TbsReaderView? = null
    private var mDownloadManager: DownloadManager? = null
    private var mRequestId: Long = 0
    private var mDownloadObserver: DownloadObserver? = null
    private var mFileUrl: String? = ""
    private var mFileName: String? = null
    private var fileName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_preview)
        setSupportActionBar(tbFilePreview)
        supportActionBar?.title = ""
        tvFilePreviewTitle!!.text = "文件预览"
        ivFilePreview.setOnClickListener { finish() }
        val intent = intent
        mFileUrl = intent.getStringExtra("fileUrl")
        fileName = intent.getStringExtra("fileName")
        tvFilePreviewTitle!!.text = fileName
        mTbsReaderView = TbsReaderView(this@FilePreviewActivity, this@FilePreviewActivity)
        rl_tbsView!!.addView(
            mTbsReaderView,
            RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        if (mFileUrl == null || mFileUrl!!.isEmpty()) {
            ToastUtils.instance()!!.showToast(this@FilePreviewActivity, "获取文件url出错了")
            return
        }
        mFileName = parseName(mFileUrl!!)
        if (isLocalExist) {
            tv_download!!.text = "打开文件"
            tv_download!!.visibility = View.GONE
            displayFile()
        } else {
            if (!mFileUrl!!.contains("http")) {
                AlertDialog.Builder(this@FilePreviewActivity)
                    .setTitle("温馨提示:")
                    .setMessage("文件的url地址不合法哟，无法进行下载")
                    .setCancelable(false)
                    .setPositiveButton(
                        "确定",
                        DialogInterface.OnClickListener { _, _ -> return@OnClickListener })
                    .create().show()
            }
            startDownload()
        }
    }

    companion object {
        @JvmStatic
        fun actionStart(context: Context?, fileUrl: String?, fileName: String?) {
            context!!.startActivity(
                Intent(
                    context,
                    FilePreviewActivity::class.java
                ).putExtra("fileUrl", fileUrl).putExtra("fileName", fileName)
            )
        }
    }

    /**
     * 将url进行encode，解决部分手机无法下载含有中文url的文件的问题（如OPPO R9）
     * @param url
     * @return
     * @author xch
     */
    private fun toUtf8String(url: String?): String {
        val sb = StringBuffer()
        for (element in url!!) {
            val c = element
            if (c.toInt() in 0..255) {
                sb.append(c)
            } else {
                var b: ByteArray
                b = try {
                    c.toString().toByteArray(charset("utf-8"))
                } catch (ex: Exception) {
                    println(ex)
                    ByteArray(0)
                }
                for (j in b.indices) {
                    var k = b[j].toInt()
                    if (k < 0) k += 256
                    sb.append("%" + Integer.toHexString(k).toUpperCase())
                }
            }
        }
        return sb.toString()
    }

    /**
     * 加载显示文件内容
     */
    private fun displayFile() {
        val bundle = Bundle()
        bundle.putString("filePath", localFile.path)
        bundle.putString(
            "tempPath", Environment.getExternalStorageDirectory()
                .path
        )
        val result = mTbsReaderView!!.preOpen(parseFormat(mFileName), false)
        if (result) {
            mTbsReaderView!!.openFile(bundle)
        } else {
            val file = File(localFile.path)
            if (file.exists()) {
                val openIntent = Intent()
                openIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                val type = getMIMEType(file)
                // 设置intent的data和Type属性。
                openIntent.setDataAndType( /* uri */Uri.fromFile(file), type)
                // 跳转
                startActivity(openIntent)
                finish()
            }
        }
    }

    private fun getMIMEType(file: File?): String {
        var type = "*/*"
        val fName = file!!.name
        // 获取后缀名前的分隔符"."在fName中的位置。
        val dotIndex = fName.lastIndexOf(".")
        if (dotIndex < 0) {
            return type
        }
        /* 获取文件的后缀名 */
        val end = fName.substring(dotIndex, fName.length).toLowerCase()
        if (end === "") return type
        // 在MIME和文件类型的匹配表中找到对应的MIME类型。
        for (i in MIME_MapTable.indices) {
            if (end == MIME_MapTable[i][0]) type = MIME_MapTable[i][1]
        }
        return type
    }

    private val MIME_MapTable = arrayOf(
        arrayOf(".3gp", "video/3gpp"),
        arrayOf(".apk", "application/vnd.android.package-archive"),
        arrayOf(".asf", "video/x-ms-asf"),
        arrayOf(".avi", "video/x-msvideo"),
        arrayOf(".bin", "application/octet-stream"),
        arrayOf(".bmp", "image/bmp"),
        arrayOf(".c", "text/plain"),
        arrayOf(".class", "application/octet-stream"),
        arrayOf(".conf", "text/plain"),
        arrayOf(".cpp", "text/plain"),
        arrayOf(".doc", "application/msword"),
        arrayOf(
            ".docx",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
        ),
        arrayOf(".xls", "application/vnd.ms-excel"),
        arrayOf(
            ".xlsx",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        ),
        arrayOf(".exe", "application/octet-stream"),
        arrayOf(".gif", "image/gif"),
        arrayOf(".gtar", "application/x-gtar"),
        arrayOf(".gz", "application/x-gzip"),
        arrayOf(".h", "text/plain"),
        arrayOf(".htm", "text/html"),
        arrayOf(".html", "text/html"),
        arrayOf(".jar", "application/java-archive"),
        arrayOf(".java", "text/plain"),
        arrayOf(".jpeg", "image/jpeg"),
        arrayOf(".jpg", "image/jpeg"),
        arrayOf(".js", "application/x-javascript"),
        arrayOf(".log", "text/plain"),
        arrayOf(".m3u", "audio/x-mpegurl"),
        arrayOf(".m4a", "audio/mp4a-latm"),
        arrayOf(".m4b", "audio/mp4a-latm"),
        arrayOf(".m4p", "audio/mp4a-latm"),
        arrayOf(".m4u", "video/vnd.mpegurl"),
        arrayOf(".m4v", "video/x-m4v"),
        arrayOf(".mov", "video/quicktime"),
        arrayOf(".mp2", "audio/x-mpeg"),
        arrayOf(".mp3", "audio/x-mpeg"),
        arrayOf(".mp4", "video/mp4"),
        arrayOf(".mpc", "application/vnd.mpohun.certificate"),
        arrayOf(".mpe", "video/mpeg"),
        arrayOf(".mpeg", "video/mpeg"),
        arrayOf(".mpg", "video/mpeg"),
        arrayOf(".mpg4", "video/mp4"),
        arrayOf(".mpga", "audio/mpeg"),
        arrayOf(".msg", "application/vnd.ms-outlook"),
        arrayOf(".ogg", "audio/ogg"),
        arrayOf(".pdf", "application/pdf"),
        arrayOf(".png", "image/png"),
        arrayOf(".pps", "application/vnd.ms-powerpoint"),
        arrayOf(".ppt", "application/vnd.ms-powerpoint"),
        arrayOf(
            ".pptx",
            "application/vnd.openxmlformats-officedocument.presentationml.presentation"
        ),
        arrayOf(".prop", "text/plain"),
        arrayOf(".rc", "text/plain"),
        arrayOf(".rmvb", "audio/x-pn-realaudio"),
        arrayOf(".rtf", "application/rtf"),
        arrayOf(".sh", "text/plain"),
        arrayOf(".tar", "application/x-tar"),
        arrayOf(".tgz", "application/x-compressed"),
        arrayOf(".txt", "text/plain"),
        arrayOf(".wav", "audio/x-wav"),
        arrayOf(".wma", "audio/x-ms-wma"),
        arrayOf(".wmv", "audio/x-ms-wmv"),
        arrayOf(".wps", "application/vnd.ms-works"),
        arrayOf(".xml", "text/plain"),
        arrayOf(".z", "application/x-compress"),
        arrayOf(".zip", "application/x-zip-compressed"),
        arrayOf("", "*/*")
    )

    private fun parseFormat(fileName: String?): String {
        return fileName!!.substring(fileName.lastIndexOf(".") + 1)
    }

    /**
     * 利用文件url转换出文件名
     * @param url
     * @return
     */
    private fun parseName(url: String?): String? {
        var fileName: String? = null
        try {
            fileName = url!!.substring(url.lastIndexOf("/") + 1)
        } finally {
            if (TextUtils.isEmpty(fileName)) {
                fileName = System.currentTimeMillis().toString()
            }
        }
        return fileName
    }

    private val isLocalExist: Boolean get() = localFile.exists()

    private val localFile: File
        get() = File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            ), mFileName
        )

    /**
     * 下载文件
     */
    private fun startDownload() {
        mDownloadObserver = DownloadObserver(Handler())
        contentResolver.registerContentObserver(
            Uri.parse("content://downloads/my_downloads"), true,
            mDownloadObserver
        )
        mDownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        //将含有中文的url进行encode
        val fileUrl = toUtf8String(mFileUrl)
        try {
            val request = DownloadManager.Request(Uri.parse(fileUrl))
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, mFileName)
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN)
            mRequestId = mDownloadManager!!.enqueue(request)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    private fun queryDownloadStatus() {
        val query = DownloadManager.Query()
            .setFilterById(mRequestId)
        var cursor: Cursor? = null
        try {
            cursor = mDownloadManager!!.query(query)
            if (cursor != null && cursor.moveToFirst()) { // 已经下载的字节数
                val currentBytes =
                    cursor.getLong(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
                // 总需下载的字节数
                val totalBytes =
                    cursor.getLong(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
                // 状态所在的列索引
                val status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                tv_download!!.text = ("下载中...(" + formatKMGByBytes(currentBytes)
                        + "/" + formatKMGByBytes(totalBytes) + ")")
                // 将当前下载的字节数转化为进度位置
                val progress = (currentBytes * 1.0 / totalBytes * 100).toInt()
                progressBar_download!!.progress = progress
                Log.i("downloadUpdate: ", "$currentBytes $totalBytes $status $progress")
                if (DownloadManager.STATUS_SUCCESSFUL == status
                    && tv_download!!.visibility == View.VISIBLE
                ) {
                    tv_download!!.visibility = View.GONE
                    tv_download!!.performClick()
                    if (isLocalExist) {
                        tv_download!!.visibility = View.GONE
                        displayFile()
                    }
                }
            }
        } finally {
            cursor?.close()
        }
    }

    override fun onCallBackAction(integer: Int, o: Any, o1: Any) {}
    override fun onDestroy() {
        super.onDestroy()
        mTbsReaderView!!.onStop()
        if (mDownloadObserver != null) {
            contentResolver.unregisterContentObserver(mDownloadObserver)
        }
    }

    override fun onPointerCaptureChanged(hasCapture: Boolean) {}

    private inner class DownloadObserver(handler: Handler) : ContentObserver(handler) {
        override fun onChange(selfChange: Boolean, uri: Uri) {
            queryDownloadStatus()
        }
    }

    /**
     * 将字节数转换为KB、MB、GB
     * @param size 字节大小
     * @return
     */
    private fun formatKMGByBytes(size: Long): String {
        val bytes = StringBuffer()
        val format = DecimalFormat("###.00")
        if (size >= 1024 * 1024 * 1024) {
            val i = size / (1024.0 * 1024.0 * 1024.0)
            bytes.append(format.format(i)).append("GB")
        } else if (size >= 1024 * 1024) {
            val i = size / (1024.0 * 1024.0)
            bytes.append(format.format(i)).append("MB")
        } else if (size >= 1024) {
            val i = size / 1024.0
            bytes.append(format.format(i)).append("KB")
        } else if (size < 1024) {
            if (size <= 0) {
                bytes.append("0B")
            } else {
                bytes.append(size.toInt()).append("B")
            }
        }
        return bytes.toString()
    }
}