package com.yinghuo.highway.di.component
import com.yhsoft.highway.backend.di.module.ApiModule
import com.yinghuo.highway.YhHwApplication
import com.yinghuo.highway.di.AppScope
import com.yinghuo.highway.di.module.AppModule
import com.yinghuo.highway.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@AppScope
@Singleton
@Component(
    modules = [
        AppModule::class,
//        FlipperModule::class,
        ApiModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(app: YhHwApplication)
    fun newActivityComponentBuilder(): ActivityComponent.Builder
    fun newFragmentComponentBuilder(): FragmentComponent.Builder
}