val libVersion: String by project

plugins {
    id("io.izzel.taboolib") version "1.40"
}

dependencies {
//    compileOnly("ink.ptms.core:v10800:10800@jar")
    api(project(":project:module-common"))
}

taboolib {
    install("common", "common-5", "module-chat", "module-configuration", "module-nms", "module-nms-util")
    install("platform-bukkit")
    options("skip-minimize", "keep-kotlin-module", "skip-plugin-file")
    classifier = null
    version = libVersion
}