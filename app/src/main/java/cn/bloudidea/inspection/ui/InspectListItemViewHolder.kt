package cn.bloudidea.inspection.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R

class InspectListItemViewHolder : RecyclerView.ViewHolder {
    var tvInspectName: TextView
    var tvInspectStatus: TextView
    var tvLevel: TextView
    var tvInspectDate: TextView

    constructor(itemView: View) : super(itemView) {
        itemView.let {
            tvInspectName = it.findViewById(R.id.tvInspectName)
            tvInspectStatus = it.findViewById(R.id.tvInspectStatus)
            tvLevel = it.findViewById(R.id.tvLevel)
            tvInspectDate = it.findViewById(R.id.tvInspectDate)
        }
    }
}