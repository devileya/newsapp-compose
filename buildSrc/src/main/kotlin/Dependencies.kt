object Dependencies {

    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.kotlinKtx}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }

    // Dagger-Hilt DI
    const val daggerHiltVersion = "2.47"
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:$daggerHiltVersion"
    const val daggerHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$daggerHiltVersion"

    // Hilt-Android DI
    private const val androidXHiltVersion = "1.0.0"
    const val androidXHiltCompiler = "androidx.hilt:hilt-compiler:$androidXHiltVersion"
    const val androidXHiltNavigation = "androidx.hilt:hilt-navigation-fragment:$androidXHiltVersion"
    const val androidXHiltWork = "androidx.hilt:hilt-work:$androidXHiltVersion"

    // Retrofit
    private const val retrofitVersion = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.2"

    // Coroutines
    private const val coroutinesVersion = "1.6.4"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
}

object Modules {
    const val utilities = ":utilities"
}