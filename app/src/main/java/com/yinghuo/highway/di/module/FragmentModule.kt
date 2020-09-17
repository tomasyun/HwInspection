package com.yinghuo.highway.di.module

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yinghuo.highway.di.FragmentScope
import com.yinghuo.highway.ui.contract.bid.BidAdapter
import com.yinghuo.highway.ui.contract.laborer.LaborerBillListAdapter
import com.yinghuo.highway.ui.contract.material.MaterialBillListAdapter
import com.yinghuo.highway.ui.contract.provisional.ProvisionGoldManageListAdapter
import com.yinghuo.highway.ui.contract.quantity.QuantityBillListAdapter
import com.yinghuo.highway.ui.cost.CostAlterManageViewPagerAdapter
import com.yinghuo.highway.ui.cost.MeterageManageViewPagerAdapter
import com.yinghuo.highway.ui.labourer.employee.EmployeeManageViewPagerAdapter
import com.yinghuo.highway.ui.labourer.salary.EmploySalaryViewPagerAdapter
import com.yinghuo.highway.ui.message.MessageListAdapter
import com.yinghuo.highway.ui.message.MsgViewPagerAdapter
import com.yinghuo.highway.ui.rate.bridge.BridgeImageRateViewPagerAdapter
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

    @Provides
    fun provideCostAlterManageViewPagerAdapter(): CostAlterManageViewPagerAdapter =
        CostAlterManageViewPagerAdapter(fragment.childFragmentManager)

    @Provides
    fun provideMeterageManageViewPagerAdapter(): MeterageManageViewPagerAdapter =
        MeterageManageViewPagerAdapter(fragment.childFragmentManager)
}