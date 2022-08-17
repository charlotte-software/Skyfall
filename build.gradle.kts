plugins {
    id("org.gradle.java")
    id("org.jetbrains.kotlin.jvm") version "1.5.30" apply false
}

subprojects {
    apply<JavaPlugin>()
    apply(plugin = "org.jetbrains.kotlin.jvm")
    repositories {
        maven {
            url = uri("https://repo.tabooproject.org/repository/releases")
        }
        mavenCentral()
    }
    dependencies {
        compileOnly("ink.ptms.core:v10800:10800@jar")
        compileOnly(kotlin("stdlib"))
    }
    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

gradle.buildFinished {
    buildDir.deleteRecursively()
}