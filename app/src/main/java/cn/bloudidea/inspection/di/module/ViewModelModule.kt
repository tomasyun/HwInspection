package cn.bloudidea.inspection.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.bloudidea.inspection.di.DaggerViewModelFactory
import cn.bloudidea.inspection.di.ViewModelKey
import cn.bloudidea.inspection.ui.*
import cn.bloudidea.inspection.ui.contract.bid.BidSectionViewModel
import cn.bloudidea.inspection.ui.contract.laborer.LaborerBillViewModel
import cn.bloudidea.inspection.ui.contract.material.MaterialBillViewModel
import cn.bloudidea.inspection.ui.contract.provisional.ProvisionGoldManageViewModel
import cn.bloudidea.inspection.ui.contract.quantity.QuantityBillViewModel
import cn.bloudidea.inspection.ui.home.HomeViewModel
import cn.bloudidea.inspection.ui.message.HasReadViewModel
import cn.bloudidea.inspection.ui.message.MessageViewModel
import cn.bloudidea.inspection.ui.message.UnReadViewModel
import cn.bloudidea.inspection.ui.mine.MineViewModel
import cn.bloudidea.inspection.ui.pic.PicViewModel
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