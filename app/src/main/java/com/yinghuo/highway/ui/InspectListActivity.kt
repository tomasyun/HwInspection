package com.yinghuo.highway.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.recyclerview.widget.LinearLayoutManager
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseActivity
import com.yinghuo.highway.util.support.EasyStateView
import kotlinx.android.synthetic.main.activity_inspect_list.*
import kotlinx.android.synthetic.main.pop_menu.view.*
import javax.inject.Inject

class InspectListActivity : BaseActivity() {
    private val vm by lazy {
        getViewModel(InspectListViewModel::class.java)
    }
    private val newData: MutableList<InspectListItem> = ArrayList()
    @Inject
    lateinit var adapter: InspectListAdapter
    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspect_list)
        setSupportActionBar(tbInspectList)
        tbInspectList.inflateMenu(R.menu.inspect_list_right_menu)
        supportActionBar?.title = ""

        when (intent.extras.get("skip")) {
            0 -> {
                tvInspectListTitle.text = "日常巡检"
                if (vm.daily.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    adapter.addItems(vm.daily)
                }
            }
            1 -> {
                tvInspectListTitle.text = "专项检查"
                if (vm.expert.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    adapter.addItems(vm.expert)
                }
            }
            2 -> {
                tvInspectListTitle.text = "施工自检"
                if (vm.self.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    adapter.addItems(vm.self)
                }
            }
        }
        ivInspectListBack.setOnClickListener { this.finish() }
        rvInspectList.layoutManager = linearLayoutManager
        rvInspectList.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (intent.extras.get("skip") == 0) {
            menuInflater.inflate(R.menu.inspect_list_right_menu, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.add -> startActivity(Intent(this, AddInspectActivity::class.java))
            R.id.overflow -> initPop(tbInspectList)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initPop(v: View) {
        val pop = PopupWindow(this)
        val view: View = layoutInflater.inflate(R.layout.pop_menu, null)
        view.let {
            it.checking.setOnClickListener {
                pop.dismiss()
                newData.clear()
                for (item in vm.daily) {
                    if (item.status == "检查中") {
                        newData.add(item)
                    }
                }
                if (newData.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    inspectListStateView.showViewState(0)
                    adapter.addItems(newData)
                    adapter.notifyDataSetChanged()
                }
            }
            it.auditing.setOnClickListener {
                pop.dismiss()
                newData.clear()
                for (item in vm.daily) {
                    if (item.status == "审核中") {
                        newData.add(item)
                    }
                }
                if (newData.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    inspectListStateView.showViewState(0)
                    adapter.addItems(newData)
                    adapter.notifyDataSetChanged()
                }
            }
            it.rectifying.setOnClickListener {
                pop.dismiss()
                newData.clear()
                for (item in vm.daily) {
                    if (item.status == "整改中") {
                        newData.add(item)
                    }
                }
                if (newData.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    inspectListStateView.showViewState(0)
                    adapter.addItems(newData)
                    adapter.notifyDataSetChanged()
                }
            }
            it.reviewing.setOnClickListener {
                pop.dismiss()
                newData.clear()
                for (item in vm.daily) {
                    if (item.status == "复检中") {
                        newData.add(item)
                    }
                }
                if (newData.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    inspectListStateView.showViewState(0)
                    adapter.addItems(newData)
                    adapter.notifyDataSetChanged()
                }
            }
            it.receiving.setOnClickListener {
                pop.dismiss()
                newData.clear()
                for (item in vm.daily) {
                    if (item.status == "验收中") {
                        newData.add(item)
                    }
                }
                if (newData.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    inspectListStateView.showViewState(0)
                    adapter.addItems(newData)
                    adapter.notifyDataSetChanged()
                }
            }
            it.finish.setOnClickListener {
                pop.dismiss()
                newData.clear()
                for (item in vm.daily) {
                    if (item.status == "已完成") {
                        newData.add(item)
                    }
                }
                if (newData.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    inspectListStateView.showViewState(0)
                    adapter.addItems(newData)
                    adapter.notifyDataSetChanged()
                }
            }
            it.all.setOnClickListener {
                pop.dismiss()
                if (vm.daily.isEmpty()) {
                    inspectListStateView.showViewState(EasyStateView.VIEW_EMPTY)
                } else {
                    inspectListStateView.showViewState(0)
                    adapter.addItems(vm.daily)
                    adapter.notifyDataSetChanged()
                }
            }
        }
        pop.contentView = view
        pop.width = ViewGroup.LayoutParams.WRAP_CONTENT
        pop.height = ViewGroup.LayoutParams.WRAP_CONTENT
        pop.setBackgroundDrawable(null)
        pop.isOutsideTouchable = true
        pop.showAsDropDown(v, v.width - 5, 5)
    }
}