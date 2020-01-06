package cn.bloudidea.inspection.ui.manager.contract

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseActivity
import kotlinx.android.synthetic.main.activity_contract_manager.*
import kotlinx.android.synthetic.main.pop_contract_manager.view.*

class ContractManagerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contract_manager)
        setSupportActionBar(tbContractManager)
        supportActionBar?.title = ""
        tvContractManagerTitle.text = "合同看板"
        ivShowMore.setOnClickListener { setUpTopBoard(tbContractManager) }
        ivContractManagerBack.setOnClickListener { finish() }
    }

    private fun setUpTopBoard(v: View) {
        val pop = PopupWindow(this);
        val view: View = LayoutInflater.from(this).inflate(R.layout.pop_contract_manager, null)
        view.let {
            it.contractBoard.setOnClickListener {
                pop.dismiss()
                tvContractManagerTitle.text = "合同看板"
            }
            it.bidSection.setOnClickListener {
                pop.dismiss()
                tvContractManagerTitle.text = "标段概况"
            }
            it.materialBill.setOnClickListener {
                pop.dismiss()
                tvContractManagerTitle.text = "材料清单"
            }
            it.laborerBill.setOnClickListener {
                pop.dismiss()
                tvContractManagerTitle.text = "计日工清单"
            }
            it.priceBill.setOnClickListener {
                pop.dismiss()
                tvContractManagerTitle.text = "价格清单"
            }
            it.periodManage.setOnClickListener {
                pop.dismiss()
                tvContractManagerTitle.text = "计量工期管理"
            }
            it.planProportionManage.setOnClickListener {
                pop.dismiss()
                tvContractManagerTitle.text = "计划比例管理"
            }
            it.provisionalGoldManage.setOnClickListener {
                pop.dismiss()
                tvContractManagerTitle.text = "暂定金清单"
            }
        }
        pop.contentView = view
        pop.width = ViewGroup.LayoutParams.MATCH_PARENT
        pop.height = ViewGroup.LayoutParams.WRAP_CONTENT
        pop.setBackgroundDrawable(null)
        pop.isOutsideTouchable = true
        pop.showAsDropDown(v, 0, 5)
    }
}