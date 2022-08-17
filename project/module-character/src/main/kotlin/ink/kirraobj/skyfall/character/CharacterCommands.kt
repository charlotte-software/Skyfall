package ink.kirraobj.skyfall.character

import ink.kirraobj.skyfall.common.fail
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.subCommand

@CommandHeader(name = "Character", aliases = ["character", "char"])
object CharacterCommands {

    @CommandBody
    val setKit = subCommand {
        dynamic(commit = "characterId") {
            execute<Player> { sender, context, _ ->
                val id = context.get(1).lowercase()
                val character = CharacterManager.characters[id] ?: run {
                    sender.fail("&c[System] &7该职业不存在.")
                    return@execute
                }
                sender.inventory.contents.toList()
                sender.inventory.armorContents.toList()
            }
        }
    }
}