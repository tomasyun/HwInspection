package com.yinghuo.highway.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yinghuo.highway.di.DaggerViewModelFactory
import com.yinghuo.highway.di.ViewModelKey
import com.yinghuo.highway.ui.*
import com.yinghuo.highway.ui.contract.bid.BidSectionViewModel
import com.yinghuo.highway.ui.contract.laborer.LaborerBillViewModel
import com.yinghuo.highway.ui.contract.material.MaterialBillViewModel
import com.yinghuo.highway.ui.contract.provisional.ProvisionGoldManageViewModel
import com.yinghuo.highway.ui.contract.quantity.QuantityBillViewModel
import com.yinghuo.highway.ui.home.HomeViewModel
import com.yinghuo.highway.ui.message.HasReadViewModel
import com.yinghuo.highway.ui.message.MessageViewModel
import com.yinghuo.highway.ui.message.UnReadViewModel
import com.yinghuo.highway.ui.mine.MineViewModel
import com.yinghuo.highway.ui.pic.PicViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PicViewModel::class)
    abstract fun bindPicViewModel(viewModel: PicViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MineViewModel::class)
    abstract fun bindMineViewModel(viewModel: MineViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MessageViewModel::class)
    abstract fun bindMessageViewModel(viewModel: MessageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(InspectListViewModel::class)
    abstract fun bindInspectListViewModel(viewModel: InspectListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddInspectViewModel::class)
    abstract fun bindAddInspectViewModel(viewModel: AddInspectViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RevisePasswordViewModel::class)
    abstract fun bindRevisePasswordViewModel(viewModel: RevisePasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingViewModel::class)
    abstract fun bindSettingViewModel(viewModel: SettingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HasReadViewModel::class)
    abstract fun bindHasReadViewModel(viewModel: HasReadViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UnReadViewModel::class)
    abstract fun bindUnReadViewModel(viewModel: UnReadViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BidSectionViewModel::class)
    abstract fun bindBidSectionViewModel(viewModel: BidSectionViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(QuantityBillViewModel::class)
    abstract fun bindQuantityBillViewModel(viewModel: QuantityBillViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LaborerBillViewModel::class)
    abstract fun bindLaborerBillViewModel(viewModel: LaborerBillViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProvisionGoldManageViewModel::class)
    abstract fun bindProvisionGoldManageViewModel(viewModel: ProvisionGoldManageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MaterialBillViewModel::class)
    abstract fun bindMaterialBillViewModel(viewModel: MaterialBillViewModel): ViewModel
}