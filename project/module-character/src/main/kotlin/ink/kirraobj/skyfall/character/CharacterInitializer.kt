package ink.kirraobj.skyfall.character

import me.skymc.taskchain.TaskChainFactory
import taboolib.platform.BukkitPlugin

object CharacterInitializer {

    fun init(plugin: BukkitPlugin) {
        CharacterManager.taskChainFactory = TaskChainFactory(plugin)
    }
}