package ink.kirraobj.skyfall.character.skill.common

import ink.kirraobj.skyfall.character.chain
import ink.kirraobj.skyfall.character.skill.CastResult
import ink.kirraobj.skyfall.character.skill.Skill
import ink.kirraobj.skyfall.character.skill.adapter.impl.AdapterLevel
import ink.kirraobj.skyfall.common.sound
import org.bukkit.Sound
import org.bukkit.event.block.BlockBreakEvent
import taboolib.common.platform.event.SubscribeEvent

object TreasureHunter : Skill(), AdapterLevel {

    override val id = "treasure_hunter"

    override val name = "宝藏猎人"

    override val cooldownSecs = 3

    override val level = 1

    override val maxLevel = 5

    @SubscribeEvent
    fun e(e: BlockBreakEvent) {
        if (e.isCancelled) {
            return
        }
        val player = e.player
        val result = cast(player, trigger = false)
        if (result != CastResult.SUCCESS) {
            return
        }
        player.sound(Sound.FIREWORK_BLAST)
        chain.apply {
            delay(20)
        }.execute()
    }
}