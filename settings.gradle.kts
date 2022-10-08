pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("library") {
            library("android-core", "androidx.core:core-ktx:1.9.0")
            library("android-appcompat", "androidx.appcompat:appcompat:1.4.2")
            library("android-material", "com.google.android.material:material:1.6.1")

            bundle("androidx", listOf("android-core", "android-appcompat"))

            val daggerHilt = version("dagger-hilt", "2.42")
            library("dagger-hilt-android", "com.google.dagger", "hilt-android").versionRef(daggerHilt)
            library("dagger-hilt-android-compiler", "com.google.dagger", "hilt-android-compiler").versionRef(daggerHilt)

            library("network-retrofit", "com.squareup.retrofit2:retrofit:2.9.0")
            library("network-okhttp", "com.squareup.okhttp3:okhttp:4.9.3")
            library("network-okhttp-loggingInterceptor", "com.squareup.okhttp3:logging-interceptor:4.9.1")
            library("network-retrofit-gsonConvertor", "com.squareup.retrofit2:converter-gson:2.9.0")

            library("rxJava", "io.reactivex.rxjava2:rxjava:2.2.21")
            library("rxAndroid", "io.reactivex.rxjava2:rxandroid:2.1.1")
            bundle("rxJava", listOf("rxJava", "rxAndroid"))

            library("timberLog", "com.jakewharton.timber:timber:5.0.1")
        }

        versionCatalogs {
            create("testLibrary") {
                library("junit4", "junit:junit:4.13.2")
            }
        }

        versionCatalogs {
            create("androidTestLibrary") {
                library("androidTestJUnit", "androidx.test.ext:junit:1.1.3")
                library("androidEspresso", "androidx.test.espresso:espresso-core:3.4.0")

                bundle("androidLibraryTest", listOf("androidTestJUnit", "androidEspresso"))
            }
        }
    }
}
rootProject.name = "BaseAndroidLibrary"
include(":app", ":base-network")
