package cn.bloudidea.inspection.ui.contract.material

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.util.ToastUtils
import javax.inject.Inject

class MaterialBillListAdapter @Inject constructor(
    private val activity: FragmentActivity,
    private val data: MutableList<MaterialBillListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MaterialBillViewHolder(
            LayoutInflater.from(activity).inflate(
                R.layout.item_material_bill, parent, false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MaterialBillViewHolder) {
            holder.let {
                it.materialBillName.text = data[position].billName
                it.materialBillUnit.text = data[position].unit
                it.materialBillPrice.text = data[position].price
                it.materialBillLevelType.text = data[position].typeLevel
                it.edit.setOnClickListener { ToastUtils.instance()!!.showToast(activity, "编辑") }
                it.delete.setOnClickListener { ToastUtils.instance()!!.showToast(activity, "删除") }
            }
        }
    }

    fun addItems(items: MutableList<MaterialBillListItem>) {
        data.addAll(items)
    }
}