package cn.bloudidea.inspection.ui.contract.bid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R
import org.jetbrains.anko.backgroundColor

class BidAdapter(private val context: FragmentActivity, private val bids: MutableList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var position: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        BidViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_bid, parent, false
            )
        )

    override fun getItemCount(): Int = bids.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BidViewHolder) {
            holder.bidNo.text = bids[position]
            if (this.position == position) {
                holder.bidNo.backgroundColor = context.resources.getColor(R.color.colorPrimary)
            } else {
                holder.bidNo.backgroundColor = context.resources.getColor(R.color.bg_default)
            }
        }

        holder.itemView.setOnClickListener {
            this.position = position
            this.notifyDataSetChanged()
        }
    }

    fun addItems(items: MutableList<String>) {
        bids.addAll(items)
    }
}