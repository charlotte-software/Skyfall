package ink.kirraobj.skyfall.character

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class CharacterProfile(val uuid: UUID) {

    val player: Player?
        get() = Bukkit.getPlayer(uuid)

    @Suppress("SpellCheckingInspection")
    val cooldownMap by lazy {
        ConcurrentHashMap<String, Long>()
    }

    var mana = 0

    companion object {

        private val profiles = mutableListOf<CharacterProfile>()

        fun getByPlayer(player: Player) = profiles.find { player.uniqueId == it.uuid }

        fun getByUUID(uuid: UUID) = profiles.find { uuid == it.uuid }

        fun drop(uuid: UUID) = profiles.removeIf { it.uuid == uuid }
    }
}