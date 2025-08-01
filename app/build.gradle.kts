plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)


}
kotlin {
    jvmToolchain(11) // Specify the JDK version you want to use
}

android {
    namespace = "com.fatokifury.focus_flow_v1"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.fatokifury.focus_flow_v1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//    kotlinOptions {
//        jvmTarget = "11"
//    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    packagingOptions { // Often needed for Compose
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    dependencies {
        implementation(libs.room.runtime)
        implementation(libs.room.ktx)
        ksp(libs.room.compiler)



        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)
    }

    dependencies {
        // Your existing dependencies
        implementation(libs.androidx.core.ktx)
        // ... etc.

        // Force Kotlin standard library version
        implementation(platform(libs.kotlin.bom)) // Add this line if using Kotlin BOM
        implementation(libs.kotlin.stdlib)     // Or ensure this uses your project's version if not using BOM

        // Or, more forcefully, if the above doesn't work:
        constraints {
            implementation("org.jetbrains.kotlin:kotlin-stdlib") {
                version {
                    strictly(libs.versions.kotlin.get()) // Force it to your 'kotlin' version from libs.versions.toml
                }
            }
            implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7") {
                version {
                    strictly(libs.versions.kotlin.get())
                }
            }
            implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") {
                version {
                    strictly(libs.versions.kotlin.get())
                }
            }
            // Add other kotlin-reflect or other kotlin modules if needed
        }
    }

}