plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "io.github.sabbib.chowdhury.base.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(library.bundles.androidx)
    implementation(library.android.material)

    // Dependency Injection
    implementation(library.dagger.hilt.android)
    kapt(library.dagger.hilt.android.compiler)

    // Retrofit
    implementation(library.network.retrofit)
    implementation(library.network.okhttp)
    implementation(library.network.okhttp.loggingInterceptor)
    implementation(library.network.retrofit.gsonConvertor)

    // RxJava
    implementation(library.bundles.rxJava)

    // Logging
    implementation(library.timberLog)

    // Tests
    testImplementation(testLibrary.junit4)
    androidTestImplementation(androidTestLibrary.bundles.androidLibraryTest)
}
