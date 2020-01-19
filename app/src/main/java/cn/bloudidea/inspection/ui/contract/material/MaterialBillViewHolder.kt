package cn.bloudidea.inspection.ui.contract.material

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R

class MaterialBillViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    var materialBillName: TextView
    var materialBillUnit: TextView
    var materialBillPrice: TextView
    var materialBillLevelType: TextView
    var edit: TextView
    var delete: TextView

    init {
        viewItem.let {
            materialBillName = it.findViewById(R.id.materialBillName)
            materialBillUnit = it.findViewById(R.id.materialBillUnit)
            materialBillPrice = it.findViewById(R.id.materialBillPrice)
            materialBillLevelType = it.findViewById(R.id.materialBillLevelType)
            edit = it.findViewById(R.id.edit)
            delete = it.findViewById(R.id.delete)
        }
    }
}