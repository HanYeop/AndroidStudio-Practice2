plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.hanyeop.multimoduleex"
    compileSdk = SdkVersions.compileSdk

    defaultConfig {
        applicationId = "com.hanyeop.multimoduleex"
        minSdk = SdkVersions.minSdk
        targetSdk = SdkVersions.targetSdk
        versionCode = AppVersions.androidVersionCode
        versionName = AppVersions.androidVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isTestCoverageEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
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
        dataBinding = true
    }
}

dependencies {
    implementation (project (":domain"))

    implementation (KTX.CORE)
    implementation (AndroidX.APP_COMPAT)
    implementation (Google.MATERIAL)
    implementation (AndroidX.CONSTRAINT_LAYOUT)
    testImplementation (TestTool.JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_ESPRESSO)
}