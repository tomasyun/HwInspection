package cn.bloudidea.inspection.ui.contract.laborer

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R

class LaborerBillItemViewHolder : RecyclerView.ViewHolder {
     lateinit var laborerBillName: TextView
     lateinit var laborerBillUnit: TextView
     lateinit var laborerBillPrice: TextView
     lateinit var laborerBillLevelType: TextView

    constructor(viewItem: View) : super(viewItem) {
        viewItem?.let {
            laborerBillName = it.findViewById(R.id.laborerBillName)
            laborerBillUnit = it.findViewById(R.id.laborerBillUnit)
            laborerBillPrice = it.findViewById(R.id.laborerBillPrice)
            laborerBillLevelType = it.findViewById(R.id.laborerBillLevelType)
        }
    }
}


