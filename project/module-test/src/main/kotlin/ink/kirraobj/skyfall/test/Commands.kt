package ink.kirraobj.skyfall.test

import ink.kirraobj.skyfall.common.fail
import ink.kirraobj.skyfall.common.sound
import org.bukkit.Sound
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.mainCommand
import taboolib.common.platform.command.subCommand
import taboolib.expansion.createHelper

@CommandHeader("test")
object Commands {

    @CommandBody
    val main = mainCommand {
        createHelper()
    }

    @CommandBody
    val sound = subCommand {
        dynamic(commit = "name") {
            suggestion<Player> { _, _ ->
                Sound.values().map { it.name }
            }
            dynamic(commit = "volume") {
                dynamic(commit = "pitch") {
                    execute<Player> { sender, context, _ ->
                        val sound = Sound.values().find { it.name == context.get(1) }
                        if (sound == null) {
                            sender.fail("&c[System] &7未找到该声音类型.")
                            return@execute
                        }
                        val volume = context.get(2).toFloatOrNull() ?: return@execute
                        val pitch = context.get(3).toFloatOrNull() ?: return@execute
                        sender.sound(sound, volume, pitch)
                    }
                }
            }
        }
    }
}