plugins {
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.android.extensions")
}

android {
    namespace = "com.example.button.to.action"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.example.button.to.action"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    androidExtensions {
        isExperimental = true
    }
}

dependencies {

    // Android, Core
    implementation(Dependencies.coreCtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    coreLibraryDesugaring(Dependencies.desugaring)

    // Lifecycle
    implementation(Dependencies.lifecycle)
    implementation(Dependencies.viewModel)
    implementation(Dependencies.liveData)

    // Compose
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.composeActivity)

    // Navigation
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
    implementation(Dependencies.navigationCompose)

    // Tests
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidJunit)
    androidTestImplementation(Dependencies.espresso)
    androidTestImplementation(Dependencies.composeJunit)

    // Koin
    implementation(Dependencies.koin)
    implementation(Dependencies.koinCompose)

    // Coroutines
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)

    // Retrofit2
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConvertorGson)
}