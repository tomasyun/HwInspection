package com.yinghuo.highway.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import com.yinghuo.highway.util.support.EasyStateView
import kotlinx.android.synthetic.main.fragment_has_read.*
import javax.inject.Inject

class HasReadFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(HasReadViewModel::class.java)
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
        return inflater.inflate(R.layout.fragment_has_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMessageHasRead.layoutManager = linearLayout
        rvMessageHasRead.adapter = msgAdapter

        if (vm.data.isEmpty()) {
            hasReadFragment.showViewState(EasyStateView.VIEW_EMPTY)
        } else {
            hasReadFragment.showViewState(0)
            msgAdapter.addItems(vm.data)
        }
    }
}