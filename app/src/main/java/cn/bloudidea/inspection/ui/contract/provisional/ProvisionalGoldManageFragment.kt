package cn.bloudidea.inspection.ui.contract.provisional

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_provision_gold_manage.*
import javax.inject.Inject

class ProvisionalGoldManageFragment : BaseFragment() {

    private val vm by lazy {
        getViewModel(ProvisionGoldManageViewModel::class.java)
    }
    @Inject
    lateinit var adapter:ProvisionGoldManageListAdapter

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_provision_gold_manage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvProvisionGoldManage.adapter=adapter
        rvProvisionGoldManage.layoutManager=layoutManager
        adapter.addItems(vm.data)
    }
}