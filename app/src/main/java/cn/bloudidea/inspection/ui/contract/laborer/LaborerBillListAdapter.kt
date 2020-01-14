package cn.bloudidea.inspection.ui.contract.laborer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.util.ToastUtils

class LaborerBillListAdapter(
    private val context: FragmentActivity,
    private val data: MutableList<LaborerBillListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        LaborerBillItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_laborer_bill, parent, false)
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LaborerBillItemViewHolder) {
            holder.let {
                it.laborerBillName.text = data[position].laborerBillName
                it.laborerBillUnit.text = data[position].laborerBillUnit
                it.laborerBillPrice.text = data[position].laborerBillPrice
                it.laborerBillLevelType.text = data[position].laborerBillLevelType
                it.edit.setOnClickListener { ToastUtils.instance()!!.showToast(context, "编辑") }
                it.delete.setOnClickListener { ToastUtils.instance()!!.showToast(context, "删除") }
            }
        }
    }

    fun addItem(items: MutableList<LaborerBillListItem>) {
        data.addAll(items)
    }
}