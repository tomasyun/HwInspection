package com.yinghuo.highway.di.component

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.yinghuo.highway.di.FragmentScope
import com.yinghuo.highway.di.module.FragmentModule
import com.yinghuo.highway.ui.contract.bid.BidSectionFragment
import com.yinghuo.highway.ui.contract.laborer.LaborerBillFragment
import com.yinghuo.highway.ui.contract.material.MaterialBillFragment
import com.yinghuo.highway.ui.contract.provisional.ProvisionalGoldManageFragment
import com.yinghuo.highway.ui.contract.quantity.QuantityBillFragment
import com.yinghuo.highway.ui.cost.CostAlterManageFragment
import com.yinghuo.highway.ui.cost.MeterageManageFragment
import com.yinghuo.highway.ui.home.HomeFragment
import com.yinghuo.highway.ui.labourer.employee.EmployeeManageFragment
import com.yinghuo.highway.ui.labourer.salary.EmployeeSalaryFragment
import com.yinghuo.highway.ui.message.HasReadFragment
import com.yinghuo.highway.ui.message.MessageFragment
import com.yinghuo.highway.ui.message.UnReadFragment
import com.yinghuo.highway.ui.mine.MineFragment
import com.yinghuo.highway.ui.pic.PicFragment
import com.yinghuo.highway.ui.rate.bridge.BridgeImageRateFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        FragmentModule::class
    ]
)
interface FragmentComponent{

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
    fun inject(fragment: MeterageManageFragment)
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
        is MeterageManageFragment -> component.inject(fragment)
    }
}