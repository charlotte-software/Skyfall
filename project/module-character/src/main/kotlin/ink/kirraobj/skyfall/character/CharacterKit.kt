package ink.kirraobj.skyfall.character

import ink.kirraobj.skyfall.character.character.Character
import org.bukkit.entity.Player
import taboolib.module.configuration.Type
import taboolib.module.configuration.createLocal

object CharacterKit {

    val file by lazy {
        createLocal("kits.json", 1200, Type.JSON)
    }

    val defaultKits = mutableMapOf<Character, Kit>()

    fun appendToPlayer(player: Player, kit: Kit) {
        kit.apply {
            player.inventory.armorContents = armorContents
            player.inventory.contents = contents
            player.updateInventory()
        }
    }
}