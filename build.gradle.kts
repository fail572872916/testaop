// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        maven { url = uri("https://plugins.gradle.org/m2/") }
        mavenLocal()
    }
    dependencies {



    }
}

plugins {
    id("com.android.application") version "7.1.3" apply false
    id("com.android.library") version "7.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
    id("io.github.wurensen.android-aspectjx") version "3.0.0"  apply false
}



task<Delete>("clean") {
    delete(rootProject.buildDir)
}
