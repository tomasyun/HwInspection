package cn.bloudidea.inspection.di.module

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cn.bloudidea.inspection.di.FragmentScope
import cn.bloudidea.inspection.ui.contract.bid.BidAdapter
import cn.bloudidea.inspection.ui.contract.laborer.LaborerBillListAdapter
import cn.bloudidea.inspection.ui.contract.material.MaterialBillListAdapter
import cn.bloudidea.inspection.ui.contract.provisional.ProvisionGoldManageListAdapter
import cn.bloudidea.inspection.ui.contract.quantity.QuantityBillListAdapter
import cn.bloudidea.inspection.ui.labourer.employee.EmployeeManageViewPagerAdapter
import cn.bloudidea.inspection.ui.labourer.salary.EmploySalaryViewPagerAdapter
import cn.bloudidea.inspection.ui.message.MessageListAdapter
import cn.bloudidea.inspection.ui.message.MsgViewPagerAdapter
import cn.bloudidea.inspection.ui.rate.bridge.BridgeImageRateViewPagerAdapter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @FragmentScope
    fun provideFragment(): Fragment = fragment

    @Provides
    fun provideMsgViewPagerAdapter(): MsgViewPagerAdapter =
        MsgViewPagerAdapter(fragment.childFragmentManager)

    @Provides
    fun provideMessageListAdapter(): MessageListAdapter =
        MessageListAdapter(fragment.activity!!, ArrayList())

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun provideBidAdapter(): BidAdapter = BidAdapter(fragment.activity!!, ArrayList())

    @Provides
    fun provideQuantityBillListAdapter(): QuantityBillListAdapter =
        QuantityBillListAdapter(fragment.activity!!, ArrayList())

    @Provides
    fun provideLaborerBillListAdapter(): LaborerBillListAdapter =
        LaborerBillListAdapter(fragment.activity!!, ArrayList())

    @Provides
    fun provideProvisionGoldManageAdapter(): ProvisionGoldManageListAdapter =
        ProvisionGoldManageListAdapter(fragment.activity!!, ArrayList())

    @Provides
    fun provideBridgeImageRateViewPagerAdapter(): BridgeImageRateViewPagerAdapter =
        BridgeImageRateViewPagerAdapter(fragment.childFragmentManager)

    @Provides
    fun provideEmployeeManageViewPagerAdapter(): EmployeeManageViewPagerAdapter =
        EmployeeManageViewPagerAdapter(fragment.childFragmentManager)

    @Provides
    fun provideEmployeeSalaryViewPagerAdapter(): EmploySalaryViewPagerAdapter =
        EmploySalaryViewPagerAdapter(fragment.childFragmentManager)

    @Provides
    fun provideMaterialBillListAdapter(): MaterialBillListAdapter =
        MaterialBillListAdapter(fragment.activity!!, ArrayList())
}