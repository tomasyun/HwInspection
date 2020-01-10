package cn.bloudidea.inspection.ui.contract.quantity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.util.ToastUtils

class QuantityBillListAdapter(
    private val context: FragmentActivity,
    private val data: MutableList<QuantityBillListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        QuantityBillItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_quantity_bill, parent, false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is QuantityBillItemViewHolder) {
            holder.let {
                it.quantityBillNo.text = data[position].quantityBillNo
                it.billName.text = data[position].billName
                it.unit.text = data[position].unit
                it.contractCount.text = data[position].contractCount
                it.contractAccount.text = data[position].contractAccount
                it.auditCount.text = data[position].auditCount
                it.auditAccount.text = data[position].auditAccount
                it.parentBill.text = data[position].parentBill
                it.levelType.text = data[position].levelType
                it.edit.setOnClickListener { ToastUtils.instance()?.showToast(context, "编辑") }
                it.delete.setOnClickListener { ToastUtils.instance()?.showToast(context, "删除") }
            }
        }
    }


    fun addItems(items: MutableList<QuantityBillListItem>) {
        data.addAll(items)
    }
}