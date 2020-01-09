package cn.bloudidea.inspection.ui.contract.quantity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter
import kotlinx.android.synthetic.main.fragment_quantity_bill.*
import kotlinx.android.synthetic.main.pop_bid_content.view.*

class QuantityBillFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quantity_bill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bidSelectLayout.setOnClickListener { showBidComponent(bidSelectLayout) }
    }

    private fun showBidComponent(v: View) {
        val pop = PopupWindow(activity)
        val view: View = layoutInflater.inflate(R.layout.pop_bid_content, null)
        val bids = arrayOf("A01", "A02", "A03", "A04", "B01", "B02")

        view.wvQuantityBid?.let {
            it.adapter = ArrayWheelAdapter(bids.toMutableList())
            it.setCyclic(false)
            it.setOnItemSelectedListener { index ->
                run {
                    tvQuantityBid.text = bids[index]
                    pop.dismiss()
                }
            }
        }
        pop.contentView = view
        pop.width = ViewGroup.LayoutParams.WRAP_CONTENT
        pop.height = ViewGroup.LayoutParams.WRAP_CONTENT
        pop.setBackgroundDrawable(null)
        pop.isOutsideTouchable = true
        pop.showAsDropDown(v, 115, 0)
    }
}