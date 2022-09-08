import org.jetbrains.kotlin.resolve.sam.SamConstructorDescriptorKindExclude.excludes

plugins {
    id("com.android.application")
    id("kotlin-android") //kotlin("android")
    id("kotlin-kapt")

    id("io.github.wurensen.android-aspectjx")

}

// ajx配置
aspectjx {
    enabled = true
    // 移除kotlin相关，编译错误和提升速度

    exclude ("kotlin.jvm", "kotlin.internal")
    exclude ("kotlinx.coroutines.internal", "kotlinx.coroutines.android")
}



android {
    compileSdk = 31

    defaultConfig {
        applicationId ="com.example.testaop"
        minSdk =21
        targetSdk = 32
        versionCode = 1
        versionName ="1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        ndk {

            abiFilters.add("arm64-v8a")
        }

    }





    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        compileOptions.encoding = Charsets.UTF_8.name()

    }

    buildFeatures {
        dataBinding = true
        viewBinding = true

    }

    aaptOptions.cruncherEnabled = false
    aaptOptions.useNewCruncher = false

    kapt.includeCompileClasspath = false

}

dependencies {

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("com.google.android.material:material:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

}
