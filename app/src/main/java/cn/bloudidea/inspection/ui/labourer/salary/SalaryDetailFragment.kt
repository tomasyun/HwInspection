package cn.bloudidea.inspection.ui.labourer.salary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import cn.bloudidea.inspection.util.support.EasyStateView
import kotlinx.android.synthetic.main.fragment_salary_detail.*

class SalaryDetailFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_salary_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        salaryDetailStateView.showViewState(EasyStateView.VIEW_EMPTY)
    }
}