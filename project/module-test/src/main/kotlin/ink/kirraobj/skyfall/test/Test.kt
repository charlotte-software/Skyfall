package ink.kirraobj.skyfall.test

import taboolib.common.platform.Plugin
import taboolib.platform.BukkitPlugin

object Test : Plugin() {

    val plugin by lazy {
        BukkitPlugin.getInstance()
    }
}