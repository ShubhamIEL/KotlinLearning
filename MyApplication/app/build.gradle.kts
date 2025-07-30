//plugins {
//    alias(libs.plugins.android.application)
//    alias(libs.plugins.kotlin.android)
//    id("com.google.dagger.hilt.android")
//    // Make sure you have this for annotation processing
//    kotlin("kapt")
//}
//
//android {
//    namespace = "com.example.myapplication"
//    compileSdk = 36
//
//    defaultConfig {
//        applicationId = "com.example.myapplication"
//        minSdk = 29 // Using 29 as required by the car libraries
//        targetSdk = 36
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//
//    kotlinOptions {
//        jvmTarget = "11"
//    }
//
//    buildFeatures {
//        viewBinding = true
//        dataBinding = true
//    }
//}
//
//dependencies {
//
//    implementation(project(":feature_profile"))
//    implementation(project(":core"))
//    // Core and UI Libraries
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    implementation(libs.androidx.activity)
//    implementation(libs.androidx.constraintlayout)
//
//    // ViewModel and LiveData
//    implementation(libs.androidx.lifecycle.viewmodel.ktx)
//    implementation(libs.androidx.lifecycle.livedata.ktx)
//
//    // Automotive Libraries
//    implementation(libs.androidx.app.automotive)
//    implementation("androidx.car.app:app:1.7.0")
//    implementation(libs.androidx.cardview) // Use the latest stable    compileOnly("com.google.android.automotive:automotive:1.2.0")
//
//    // Testing Libraries
//
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    testImplementation(libs.junit)
//    testImplementation(libs.androidx.core.testing)
//    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")
//    testImplementation("org.mockito.kotlin:mockito-kotlin:6.0.0")
//    implementation("com.google.dagger:hilt-android:2.57")
//    kapt("com.google.dagger:hilt-android-compiler:2.57")
//    implementation("androidx.activity:activity-ktx:1.10.1")
//
//}
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":feature_profile"))
    implementation(project(":core"))
    implementation(libs.material)
    implementation("com.google.dagger:hilt-android:2.57")
    kapt("com.google.dagger:hilt-android-compiler:2.57")
    implementation("androidx.core:core-ktx:1.16.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("androidx.activity:activity-ktx:1.10.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    // Optional: If your tests use Mockito
    testImplementation("org.mockito.kotlin:mockito-kotlin:6.0.0")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}