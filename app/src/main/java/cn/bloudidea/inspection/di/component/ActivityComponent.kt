package cn.bloudidea.inspection.di.component

import cn.bloudidea.inspection.base.BaseActivity
import cn.bloudidea.inspection.di.ActivityScope
import cn.bloudidea.inspection.di.module.ActivityModule
import cn.bloudidea.inspection.ui.*
import cn.bloudidea.inspection.ui.save.SaveStepDistanceActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ActivityModule::class
    ]
)
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(module: ActivityModule): Builder
        fun build(): ActivityComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: InspectListActivity)
    fun inject(activity: AddInspectActivity)
    fun inject(activity: RevisePasswordActivity)
    fun inject(activity: SettingActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: SplashActivity)
    fun inject(activity: SaveStepDistanceActivity)
}

fun ActivityComponent.Builder.buildAndInject(activity: BaseActivity) {
    val component = activityModule(ActivityModule(activity)).build()

    when (activity) {
        is MainActivity -> component.inject(activity)
        is InspectListActivity -> component.inject(activity)
        is AddInspectActivity -> component.inject(activity)
        is RevisePasswordActivity -> component.inject(activity)
        is SettingActivity -> component.inject(activity)
        is LoginActivity -> component.inject(activity)
        is SplashActivity -> component.inject(activity)
        is SaveStepDistanceActivity -> component.inject(activity)
    }
}