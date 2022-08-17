val libVersion: String by project

plugins {
    kotlin("plugin.lombok") version "1.7.10"
    id("io.freefair.lombok") version "5.3.0"
    id("io.izzel.taboolib") version "1.40"
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.24")
}

taboolib {
    install("common", "common-5", "module-chat", "module-configuration", "module-nms", "module-nms-util")
    install("platform-bukkit")
    options("skip-minimize", "keep-kotlin-module", "skip-plugin-file")
    classifier = null
    version = libVersion
}