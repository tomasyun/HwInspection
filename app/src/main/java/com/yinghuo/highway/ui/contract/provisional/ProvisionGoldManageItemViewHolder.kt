package com.yinghuo.highway.ui.contract.provisional

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yinghuo.highway.R

class ProvisionGoldManageItemViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    var provisionGoldNo: TextView
    var provisionGoldName: TextView
    var provisionGoldContractCount: TextView
    var provisionGoldContractAccount: TextView
    var provisionGoldUnit: TextView
    var edit: ImageView
    var delete: ImageView

    init {
        viewItem.let {
            provisionGoldNo = it.findViewById(R.id.provisionGoldNo)
            provisionGoldName = it.findViewById(R.id.provisionGoldName)
            provisionGoldContractCount = it.findViewById(R.id.provisionGoldContractCount)
            provisionGoldContractAccount = it.findViewById(R.id.provisionGoldContractAccount)
            provisionGoldUnit = it.findViewById(R.id.provisionGoldUnit)
            edit = it.findViewById(R.id.edit)
            delete = it.findViewById(R.id.delete)
        }
    }
}