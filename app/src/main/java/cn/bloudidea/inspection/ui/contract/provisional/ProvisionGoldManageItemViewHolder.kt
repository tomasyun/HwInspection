package cn.bloudidea.inspection.ui.contract.provisional

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R

class ProvisionGoldManageItemViewHolder : RecyclerView.ViewHolder {
    lateinit var provisionGoldNo: TextView
    lateinit var provisionGoldName: TextView
    lateinit var provisionGoldContractCount: TextView
    lateinit var provisionGoldContractAccount: TextView
    lateinit var provisionGoldUnit: TextView

    constructor(viewItem: View) : super(viewItem) {
        viewItem?.let {
            provisionGoldNo = it.findViewById(R.id.provisionGoldNo)
            provisionGoldName = it.findViewById(R.id.provisionGoldName)
            provisionGoldContractCount = it.findViewById(R.id.provisionGoldContractCount)
            provisionGoldContractAccount = it.findViewById(R.id.provisionGoldContractAccount)
            provisionGoldUnit = it.findViewById(R.id.provisionGoldUnit)
        }
    }
}