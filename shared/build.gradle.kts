import co.touchlab.faktory.versionmanager.TimestampVersionManager

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("co.touchlab.faktory.kmmbridge") version "0.3.7"
    `maven-publish`
}
publishing {
    // Externally set these values. Generally ~/.gradle/gradle.properties or CI Secrets
    /*    val publishUsername: String by project
    val publishPassword: String by project*/
    val myPAT:String by project
    repositories {
        maven {
            url = uri("https://pkgs.dev.azure.com/ryanjfoster94/_packaging/ryanjfoster94/maven/v1")
            credentials {
                username = "ryan.foster94"
                password =myPAT
            }
        }
    }
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "PublixAnalyticsLogger"
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.rf.empty_kmm_lib_test"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}
kotlinArtifacts{
    Native.XCFramework("TestEmptyLib") {
        targets(iosX64, iosArm64, iosSimulatorArm64)
        setModules(
            project(":shared")
        )
    }
}
//addGithubPackagesRepository()


kmmbridge {
    //version = "1"
    gitTagVersions()
    versionPrefix.set("0.1")
    spm()
    mavenPublishArtifacts()
}
