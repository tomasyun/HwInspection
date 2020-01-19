package cn.bloudidea.inspection.ui.contract.material

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import cn.bloudidea.inspection.util.support.EasyStateView
import kotlinx.android.synthetic.main.fragment_material_bill.*
import javax.inject.Inject

class MaterialBillFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(MaterialBillViewModel::class.java)
    }
    @Inject
    lateinit var adapter: MaterialBillListAdapter
    @Inject
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_material_bill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMaterialBill.layoutManager = layoutManager
        rvMaterialBill.adapter = adapter

        if (vm.data.isEmpty()) {
            materialBillStateView.showViewState(EasyStateView.VIEW_EMPTY)
        } else {
            adapter.addItems(vm.data)
        }
    }
}