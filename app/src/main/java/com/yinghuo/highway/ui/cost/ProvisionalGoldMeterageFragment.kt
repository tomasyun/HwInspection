package com.yinghuo.highway.ui.cost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yinghuo.highway.R
import com.yinghuo.highway.base.BaseFragment
import com.yinghuo.highway.util.support.EasyStateView
import kotlinx.android.synthetic.main.fragment_provisional_gold_meterage.*

class ProvisionalGoldMeterageFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_provisional_gold_meterage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        provisionalMeterageStateView.showViewState(EasyStateView.VIEW_EMPTY)
    }
}