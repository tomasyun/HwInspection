package cn.bloudidea.inspection.di.component

import androidx.fragment.app.Fragment
import cn.bloudidea.inspection.di.FragmentScope
import cn.bloudidea.inspection.di.module.FragmentModule
import cn.bloudidea.inspection.ui.contract.bid.BidSectionFragment
import cn.bloudidea.inspection.ui.contract.laborer.LaborerBillFragment
import cn.bloudidea.inspection.ui.contract.material.MaterialBillFragment
import cn.bloudidea.inspection.ui.contract.provisional.ProvisionalGoldManageFragment
import cn.bloudidea.inspection.ui.contract.quantity.QuantityBillFragment
import cn.bloudidea.inspection.ui.cost.CostAlterManageFragment
import cn.bloudidea.inspection.ui.home.HomeFragment
import cn.bloudidea.inspection.ui.labourer.employee.EmployeeManageFragment
import cn.bloudidea.inspection.ui.labourer.salary.EmployeeSalaryFragment
import cn.bloudidea.inspection.ui.message.HasReadFragment
import cn.bloudidea.inspection.ui.message.MessageFragment
import cn.bloudidea.inspection.ui.message.UnReadFragment
import cn.bloudidea.inspection.ui.mine.MineFragment
import cn.bloudidea.inspection.ui.pic.PicFragment
import cn.bloudidea.inspection.ui.rate.bridge.BridgeImageRateFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        FragmentModule::class
    ]
)
interface FragmentComponent {

    @Subcomponent.Builder
    interface Builder {
        fun fragmentModule(module: FragmentModule): Builder
        fun build(): FragmentComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: MessageFragment)
    fun inject(fragment: MineFragment)
    fun inject(fragment: PicFragment)
    fun inject(fragment: HasReadFragment)
    fun inject(fragment: UnReadFragment)
    fun inject(fragment: BidSectionFragment)
    fun inject(fragment: QuantityBillFragment)
    fun inject(fragment: LaborerBillFragment)
    fun inject(fragment: ProvisionalGoldManageFragment)
    fun inject(fragment: BridgeImageRateFragment)
    fun inject(fragment: EmployeeManageFragment)
    fun inject(fragment: EmployeeSalaryFragment)
    fun inject(fragment: MaterialBillFragment)
    fun inject(fragment: CostAlterManageFragment)
}

fun FragmentComponent.Builder.buildAndInject(fragment: Fragment) {
    val component = fragmentModule(FragmentModule(fragment)).build()

    when (fragment) {
        is HomeFragment -> component.inject(fragment)
        is MessageFragment -> component.inject(fragment)
        is MineFragment -> component.inject(fragment)
        is PicFragment -> component.inject(fragment)
        is HasReadFragment -> component.inject(fragment)
        is UnReadFragment -> component.inject(fragment)
        is BidSectionFragment -> component.inject(fragment)
        is QuantityBillFragment -> component.inject(fragment)
        is LaborerBillFragment -> component.inject(fragment)
        is ProvisionalGoldManageFragment -> component.inject(fragment)
        is BridgeImageRateFragment -> component.inject(fragment)
        is EmployeeManageFragment -> component.inject(fragment)
        is EmployeeSalaryFragment -> component.inject(fragment)
        is MaterialBillFragment -> component.inject(fragment)
        is CostAlterManageFragment -> component.inject(fragment)
    }
}