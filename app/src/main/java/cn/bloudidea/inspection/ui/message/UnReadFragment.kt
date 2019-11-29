package cn.bloudidea.inspection.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_un_read.*
import javax.inject.Inject

class UnReadFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(UnReadViewModel::class.java)
    }

    @Inject
    lateinit var msgAdapter: MessageListAdapter
    @Inject
    lateinit var linearLayout: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_un_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMessageUnRead.layoutManager = linearLayout
        rvMessageUnRead.adapter = msgAdapter
        msgAdapter.addItems(vm.data)
    }
}