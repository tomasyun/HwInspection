package cn.bloudidea.inspection.ui.message

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R

class MessageListItemViewHolder : RecyclerView.ViewHolder {
    lateinit var tvMessageItemTitle: TextView
    lateinit var tvMessageItemDate: TextView
    lateinit var tvMessageItemSender: TextView

    constructor(viewItem: View) : super(viewItem) {
        viewItem?.let {
            tvMessageItemTitle = it.findViewById(R.id.tvMessageItemTitle)
            tvMessageItemDate = it.findViewById(R.id.tvMessageItemDate)
            tvMessageItemSender = it.findViewById(R.id.tvMessageItemSender)
        }
    }

}