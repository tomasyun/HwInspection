package cn.bloudidea.inspection.ui.contract.laborer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_laborer_bill.*
import javax.inject.Inject

class LaborerBillFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(LaborerBillViewModel::class.java)
    }
    @Inject
    lateinit var adapter: LaborerBillListAdapter
    @Inject
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_laborer_bill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvLaborerBill.adapter = adapter
        rvLaborerBill.layoutManager = layoutManager
        adapter.addItem(vm.data)
    }
}