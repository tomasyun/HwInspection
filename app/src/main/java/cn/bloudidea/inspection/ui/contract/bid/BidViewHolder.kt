package cn.bloudidea.inspection.ui.contract.bid

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R

class BidViewHolder : RecyclerView.ViewHolder {
    lateinit var bidNo: TextView

    constructor(viewItem: View) : super(viewItem) {
        bidNo = viewItem.findViewById(R.id.bidNo)
    }
}