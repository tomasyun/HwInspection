package cn.bloudidea.inspection.ui.message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import cn.bloudidea.inspection.R

class MessageListAdapter(
    private val context: FragmentActivity,
    private val data: MutableList<MessageListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MessageListItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_message_list, parent, false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MessageListItemViewHolder) {
            holder?.let {
                it.tvMessageItemTitle?.text = data[position].title
                it.tvMessageItemDate?.text = data[position].date
                it.tvMessageItemSender?.text = data[position].sender
            }
        }

        holder.itemView.setOnClickListener { }
    }


    fun addItems(items: MutableList<MessageListItem>) {
        data.addAll(items)
    }
}