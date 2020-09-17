import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
    id("com.akaita.android.easylauncher")
}

androidExtensions {
    isExperimental = true
    features = setOf("views", "parcelize")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        targetSdkVersion(28)
        minSdkVersion(21)
        applicationId = "com.yinghuo.highway"
        versionCode = 1
        versionName = "1.0"
        val scheme = "highway"
        buildConfigField("String", "SCHEME", "\"$scheme\"")
        manifestPlaceholders = mapOf(
            "APPLICATION_ID" to applicationId,
            "SCHEME" to scheme
        )
        ndk { abiFilters("armeabi", "armeabi-v7a", "x86", "mips") }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
//    dataBinding { isEnabled = true }
    dexOptions {
        preDexLibraries = true
        maxProcessCount = 8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":backend"))
    implementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.recyclerview:recyclerview:1.2.0-alpha05")
    implementation("androidx.constraintlayout:constraintlayout:2.0.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("android.arch.navigation:navigation-fragment-ktx:1.0.0")
    implementation("android.arch.navigation:navigation-ui-ktx:1.0.0")
    implementation("com.uber.autodispose:autodispose:1.4.0")
    implementation("com.uber.autodispose:autodispose-android:1.4.0")
    implementation("com.uber.autodispose:autodispose-android-archcomponents:1.4.0")
    implementation("com.google.dagger:dagger:2.28")
    kapt("com.google.dagger:dagger-compiler:2.25.2")
    implementation("androidx.room:room-runtime:2.2.5")
    kapt("androidx.room:room-compiler:2.2.5")
    implementation("androidx.room:room-rxjava2:2.2.5")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("com.evernote:android-state:1.4.1")
    kapt("com.evernote:android-state-processor:1.4.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("cn.bingoogolapple:bga-banner:3.0.0@aar")
    implementation("org.jetbrains.anko:anko:0.10.8")
    implementation("com.tbruyelle.rxpermissions2:rxpermissions:0.9.5@aar")
    implementation("com.zhihu.android:matisse:0.5.3-beta3")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("io.github.inflationx:calligraphy3:3.1.1")
    implementation("io.github.inflationx:viewpump:2.0.3")
    api("com.tencent.tbs.tbssdk:sdk:43697")
    implementation("com.github.abel533:ECharts:3.0.0.2")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.contrarywind:Android-PickerView:4.1.9")
    implementation("com.nineoldandroids:library:2.4.0")
    implementation("com.melnykov:floatingactionbutton:1.3.0")
    implementation("com.gyf.immersionbar:immersionbar:2.3.3")
    implementation("com.jakewharton.timber:timber:4.7.1")
//    debugImplementation("com.facebook.flipper:flipper:0.23.2")
//    debugImplementation("com.facebook.soloader:soloader:0.8.0")
//    releaseImplementation("com.facebook.flipper:flipper-noop:0.23.2")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-core:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-attr:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-build-config:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-crash:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-disk:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-geiger-counter:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-measurement:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-phoenix:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-recorder:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-shared-preferences:0.9.27")
//    debugImplementation("com.willowtreeapps.hyperion:hyperion-timber:0.9.27")
//    releaseImplementation("com.willowtreeapps.hyperion:hyperion-core-no-op:0.9.27")
}
