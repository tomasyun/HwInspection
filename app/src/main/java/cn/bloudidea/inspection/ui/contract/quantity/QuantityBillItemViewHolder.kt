package cn.bloudidea.inspection.ui.contract.quantity

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R

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
        }
    }
}