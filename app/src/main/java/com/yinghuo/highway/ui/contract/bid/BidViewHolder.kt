package com.yinghuo.highway.ui.contract.bid

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yinghuo.highway.R

class BidViewHolder : RecyclerView.ViewHolder {
    lateinit var bidNo: TextView

    constructor(viewItem: View) : super(viewItem) {
        bidNo = viewItem.findViewById(R.id.bidNo)
    }
}