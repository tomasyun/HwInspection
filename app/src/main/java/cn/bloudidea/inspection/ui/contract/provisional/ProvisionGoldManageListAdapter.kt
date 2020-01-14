package cn.bloudidea.inspection.ui.contract.provisional

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.util.ToastUtils
import javax.inject.Inject

class ProvisionGoldManageListAdapter @Inject constructor(
    private val context: FragmentActivity,
    private val data: MutableList<ProvisionGoldManageListItem>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ProvisionGoldManageItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_provision_gold_manage, parent, false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProvisionGoldManageItemViewHolder) {
            holder.let {
                it.provisionGoldNo.text = data[position].provisionGoldNo
                it.provisionGoldName.text = data[position].provisionGoldName
                it.provisionGoldContractCount.text = data[position].provisionGoldContractCount
                it.provisionGoldContractAccount.text = data[position].provisionGoldContractAccount
                it.provisionGoldUnit.text = data[position].provisionGoldUnit
                it.edit.setOnClickListener { ToastUtils.instance()?.showToast(context, "编辑") }
                it.delete.setOnClickListener { ToastUtils.instance()?.showToast(context, "删除") }
            }
        }
    }

    fun addItems(items:MutableList<ProvisionGoldManageListItem>){
        data.addAll(items)
    }
}