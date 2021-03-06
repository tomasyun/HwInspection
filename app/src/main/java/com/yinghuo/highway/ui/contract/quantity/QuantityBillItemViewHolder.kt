package com.yinghuo.highway.ui.contract.quantity

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yinghuo.highway.R

class QuantityBillItemViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {

    var quantityBillNo: TextView
    var billName: TextView
    var unit: TextView
    var contractCount: TextView
    var contractAccount: TextView
    var auditCount: TextView
    var auditAccount: TextView
    var parentBill: TextView
    var levelType: TextView
    var edit: ImageView
    var delete: ImageView

    init {
        viewItem.let {
            quantityBillNo = it.findViewById(R.id.quantityBillNo)
            billName = it.findViewById(R.id.billName)
            unit = it.findViewById(R.id.unit)
            contractCount = it.findViewById(R.id.contractCount)
            contractAccount = it.findViewById(R.id.contractAccount)
            auditCount = it.findViewById(R.id.auditCount)
            auditAccount = it.findViewById(R.id.auditAccount)
            parentBill = it.findViewById(R.id.parentBill)
            levelType = it.findViewById(R.id.levelType)
            edit = it.findViewById(R.id.edit)
            delete = it.findViewById(R.id.delete)
        }
    }
}