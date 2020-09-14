package cn.bloudidea.inspection.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R

class InspectListAdapter constructor(
    private val context: Context,
    private val data: MutableList<InspectListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        InspectListItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_inspect_list, parent, false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is InspectListItemViewHolder) {
            holder?.let {
                it.tvInspectName?.text = data[position].name
                it.tvInspectStatus?.text = data[position].status
                it.tvLevel?.text = data[position].level
                it.tvInspectDate?.text = data[position].date
            }
        }
        holder.itemView.setOnClickListener {
            context.startActivity(
                Intent(
                    context,
                    InspectInfoActivity::class.java
                )
            )
        }
    }

    fun addItems(items: MutableList<InspectListItem>) {
        if (data.size != 0) {
            data.clear()
        }
        data.addAll(items)
    }
}