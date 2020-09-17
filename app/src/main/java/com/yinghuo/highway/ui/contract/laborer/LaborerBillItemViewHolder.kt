package com.yinghuo.highway.ui.contract.laborer

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yinghuo.highway.R

class LaborerBillItemViewHolder : RecyclerView.ViewHolder {
    lateinit var laborerBillName: TextView
    lateinit var laborerBillUnit: TextView
    lateinit var laborerBillPrice: TextView
    lateinit var laborerBillLevelType: TextView
    lateinit var edit: ImageView
    lateinit var delete: ImageView

    constructor(viewItem: View) : super(viewItem) {
        viewItem?.let {
            laborerBillName = it.findViewById(R.id.laborerBillName)
            laborerBillUnit = it.findViewById(R.id.laborerBillUnit)
            laborerBillPrice = it.findViewById(R.id.laborerBillPrice)
            laborerBillLevelType = it.findViewById(R.id.laborerBillLevelType)
            edit = it.findViewById(R.id.edit)
            delete = it.findViewById(R.id.delete)
        }
    }
}


