package com.yinghuo.highway.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import com.yinghuo.highway.util.support.EasyStateView
import kotlinx.android.synthetic.main.fragment_un_read.*
import javax.inject.Inject

class UnReadFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(UnReadViewModel::class.java)
    }

    @Inject
    lateinit var msgAdapter: MessageListAdapter
    @Inject
    lateinit var linearLayout: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_un_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMessageUnRead.layoutManager = linearLayout
        rvMessageUnRead.adapter = msgAdapter

        if (vm.data.isEmpty()) {
            unReadStateView.showViewState(EasyStateView.VIEW_EMPTY)
        } else {
            unReadStateView.showViewState(0)
            msgAdapter.addItems(vm.data)
        }
    }
}