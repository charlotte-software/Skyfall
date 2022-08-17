package ink.kirraobj.skyfall.common

import net.minecraft.server.v1_8_R3.EntityLightning
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityWeather
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld
import org.bukkit.entity.Player
import taboolib.module.nms.sendPacket
import taboolib.platform.util.onlinePlayers

fun playThunderEffect(thunderLocation: Location, players: List<Player> = onlinePlayers, silent: Boolean = false) {
    val lightning = EntityLightning(
        (thunderLocation.world as CraftWorld).handle,
        thunderLocation.x,
        thunderLocation.y,
        thunderLocation.z,
        true,
        silent
    )
    val packet = PacketPlayOutSpawnEntityWeather(lightning)
    players.forEach {
        it.sendPacket(packet)
    }
}