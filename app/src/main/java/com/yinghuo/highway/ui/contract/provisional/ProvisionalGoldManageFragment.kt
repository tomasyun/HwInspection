package com.yinghuo.highway.ui.contract.provisional

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_provision_gold_manage.*
import javax.inject.Inject

class ProvisionalGoldManageFragment : BaseFragment() {

    private val vm by lazy {
        getViewModel(ProvisionGoldManageViewModel::class.java)
    }
    @Inject
    lateinit var adapter: ProvisionGoldManageListAdapter

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_provision_gold_manage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvProvisionGoldManage.adapter = adapter
        rvProvisionGoldManage.layoutManager = layoutManager
        adapter.addItems(vm.data)

        fab.setOnClickListener {
            rvProvisionGoldManage.smoothScrollToPosition(0);
        }
    }

    fun moveToPosition(manager: LinearLayoutManager, mRecyclerView: RecyclerView, n: Int) {
        val firstItem = manager.findFirstCompletelyVisibleItemPosition()
        val lastItem = manager.findLastVisibleItemPosition();
        if (n < firstItem) {
            mRecyclerView.scrollToPosition(n)
        } else if (n < lastItem) {
            val top = mRecyclerView.getChildAt(n - firstItem).top
            mRecyclerView.scrollBy(0, top)
        } else {
            mRecyclerView.scrollToPosition(n)
        }
    }

    fun moveToPosition(manager: LinearLayoutManager, n: Int) {
        manager.scrollToPositionWithOffset(n, 0);
        manager.stackFromEnd = true;
    }
}

