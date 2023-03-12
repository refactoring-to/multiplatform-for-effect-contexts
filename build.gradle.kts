plugins {
    kotlin("multiplatform") version "1.8.0"
}

group = "me.nat"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(17)
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        
        val jvmMain by getting
        val jvmTest by getting
    }
    
    targets.all {
        compilations.all {
            compilerOptions.configure {
                freeCompilerArgs.set(listOf("-Xcontext-receivers"))
            }
        }
    }
}

