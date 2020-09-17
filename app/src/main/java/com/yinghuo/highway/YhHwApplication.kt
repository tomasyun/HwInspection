package com.yinghuo.highway

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.yhsoft.highway.backend.di.module.ApiModule
//import com.facebook.flipper.core.FlipperClient
import com.google.gson.GsonBuilder
import com.tencent.smtt.sdk.QbSdk
import com.yinghuo.highway.di.component.AppComponent
import com.yinghuo.highway.di.component.DaggerAppComponent
import com.yinghuo.highway.di.module.AppModule
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject

open class YhHwApplication : Application() {
    lateinit var component: AppComponent
//    @Inject
//    lateinit var flipperClient: FlipperClient
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = createComponent()
        component.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
//        flipperClient.start()

        ViewPump.init(
            ViewPump.builder().addInterceptor(
                CalligraphyInterceptor(
                    CalligraphyConfig.Builder().setDefaultFontPath(
                        "fonts/gtw.ttf"
                    ).setFontAttrId(R.attr.fontPath).setFontMapper { font -> font }.build()
                )
            ).build()
        )

        val cb: QbSdk.PreInitCallback = object : QbSdk.PreInitCallback {
            override fun onCoreInitFinished() {
            }

            override fun onViewInitFinished(p: Boolean) {
            }
        }

        QbSdk.initX5Environment(applicationContext, cb);
    }

    protected open fun createComponent(): AppComponent {
        val httpClientBuilder = OkHttpClient.Builder()
        val gsb = GsonBuilder()

        return DaggerAppComponent.builder()
            .appModule(AppModule(this))
//            .flipperModule(FlipperModule(this, httpClientBuilder))
            .apiModule(ApiModule(httpClientBuilder, gsb))
            .build()
    }

    companion object {
        // 伴生对象
        lateinit var instance: YhHwApplication
            private set
    }
}
