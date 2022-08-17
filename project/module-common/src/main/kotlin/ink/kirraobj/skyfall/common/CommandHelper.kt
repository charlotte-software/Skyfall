package ink.kirraobj.skyfall.common

import org.bukkit.Sound
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import taboolib.module.chat.colored

fun CommandSender.success(str: String) {
    success(*arrayOf(str))
}

fun CommandSender.success(str: List<String>) {
    success(*str.toTypedArray())
}

fun CommandSender.success(vararg str: String) {
    if (this is Player) {
        sound(Sound.SUCCESSFUL_HIT, 1f, 1.5f)
    }
    send(*str)
}

fun CommandSender.info(str: String) {
    info(*arrayOf(str))
}

fun CommandSender.info(str: List<String>) {
    info(*str.toTypedArray())
}

fun CommandSender.info(vararg str: String) {
    if (this is Player) {
        sound(Sound.ITEM_PICKUP, 1f, 1.5f)
    }
    send(*str)
}

fun CommandSender.fail(str: String) {
    fail(*arrayOf(str))
}

fun CommandSender.fail(str: List<String>) {
    fail(*str.toTypedArray())
}

fun CommandSender.fail(vararg str: String) {
    if (this is Player) {
        sound(Sound.NOTE_BASS_DRUM, 1f, 1.5f)
    }
    send(*str)
}

private fun CommandSender.send(vararg str: String) {
    str.forEach {
        sendMessage(it.colored())
    }
}