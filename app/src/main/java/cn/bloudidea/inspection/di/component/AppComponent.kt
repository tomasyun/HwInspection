package cn.bloudidea.inspection.di.component

import cn.bloudidea.inspection.InspectionApplication
import cn.bloudidea.inspection.backend.di.module.ApiModule
import cn.bloudidea.inspection.di.AppScope
import cn.bloudidea.inspection.di.module.AppModule
import cn.bloudidea.inspection.di.module.FlipperModule
import cn.bloudidea.inspection.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@AppScope
@Singleton
@Component(
    modules = [
        AppModule::class,
        FlipperModule::class,
        ApiModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(app: InspectionApplication)

    fun newActivityComponentBuilder(): ActivityComponent.Builder

    fun newFragmentComponentBuilder(): FragmentComponent.Builder
}