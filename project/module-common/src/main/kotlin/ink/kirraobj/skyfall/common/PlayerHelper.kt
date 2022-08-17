package ink.kirraobj.skyfall.common

import net.minecraft.server.v1_8_R3.MobEffectList
import org.bukkit.Sound
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType


fun Player.sound(type: Sound, volume: Float = 1f, pitch: Float = 1f) {
    playSound(location, type, volume, pitch)
}

fun Player.isCritical(): Boolean {
    val entityPlayer = (this as CraftPlayer).handle
    return entityPlayer.fallDistance > 0.0f && !entityPlayer.onGround && !entityPlayer.k_() && !entityPlayer.V() && !entityPlayer.hasEffect(MobEffectList.BLINDNESS) && entityPlayer.vehicle == null
}

fun Player.takeOneFromHand() {
    val item = inventory.itemInHand ?: return
    item.amount -= 1
}

fun Player.denyMovement() {
    isFlying = false
    walkSpeed = 0.0f
    foodLevel = 0
    isSprinting = false
    addPotionEffect(PotionEffect(PotionEffectType.JUMP, Int.MAX_VALUE, 200))
}

fun Player.allowMovement() {
    isFlying = false
    walkSpeed = 0.2f
    foodLevel = 20
    isSprinting = true
    removePotionEffect(PotionEffectType.JUMP)
}