package com.yinghuo.highway.ui.contract.bid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_bid_section.*
import javax.inject.Inject

class BidSectionFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(BidSectionViewModel::class.java)
    }

    @Inject
    lateinit var bidAdapter: BidAdapter
    @Inject
    lateinit var linearLayout: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bid_section, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bidRecyclerView.layoutManager = linearLayout
        bidRecyclerView.adapter = bidAdapter
        bidAdapter.addItems(vm.data)
    }
}