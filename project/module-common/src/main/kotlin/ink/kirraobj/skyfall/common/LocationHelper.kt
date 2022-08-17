package ink.kirraobj.skyfall.common

import org.bukkit.Location
import org.bukkit.inventory.ItemStack

fun Location.dropItemNaturally(item: ItemStack) {
    world.dropItemNaturally(this, item)
}