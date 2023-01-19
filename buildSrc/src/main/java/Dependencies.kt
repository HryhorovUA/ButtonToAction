object Dependencies {

    // Gradle
    val gradle by lazy { "com.android.tools.build:gradle:${Versions.gradle}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val googleServices by lazy { "com.google.gms:google-services:${Versions.googleServices}" }

    // Android, Core
    val coreCtx by lazy { "androidx.core:core-ktx:${Versions.coreCtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val desugaring by lazy { "com.android.tools:desugar_jdk_libs:${Versions.desugaring}" }

    // Lifecycle
    val lifecycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
    val viewModel by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
    val liveData by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }

    // Compose
    val composeUI by lazy { "androidx.compose.ui:ui:${Versions.composeAndroidX}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.composeMaterial}" }
    val composePreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.composeAndroidX}" }
    val composeTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeAndroidX}" }
    val composeConstraintLayout by lazy { "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val composeLivedata by lazy { "androidx.compose.runtime:runtime-livedata:${Versions.composeLiveData}" }
    val composePullToRefresh by lazy { "com.google.accompanist:accompanist-swiperefresh:${Versions.composePullToRefresh}" }

    // Navigation
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
    val navigationUI by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigation}" }

    // Tests
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val androidJunit by lazy { "androidx.test.ext:junit:${Versions.androidJunit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    val composeJunit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.composeJunit}" }

    // Koin
    val koin by lazy { "io.insert-koin:koin-android:${Versions.koin}" }
    val koinCompose by lazy { "io.insert-koin:koin-androidx-compose:${Versions.koin}" }

    // Coroutines
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }

    // Retrofit
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitConvertorGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
}
