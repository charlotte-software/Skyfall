package ink.kirraobj.skyfall.character.skill

import ink.kirraobj.skyfall.character.CharacterCooldown.isInCooldown
import ink.kirraobj.skyfall.character.CharacterCooldown.refreshCooldown
import ink.kirraobj.skyfall.character.CharacterProfile
import ink.kirraobj.skyfall.character.event.SkillEvent
import org.bukkit.entity.Player

abstract class Skill {

    abstract val id: String

    abstract val name: String

    abstract var level: Int

    abstract val maxLevel: Int

    @Suppress("SpellCheckingInspection")
    abstract val cooldownSecs: Int

    abstract val costMana: Int

    fun cast(player: Player, trigger: Boolean = true): CastResult {
        val profile = CharacterProfile.getByPlayer(player) ?: return CastResult.OTHER
        return when {
            profile.mana < costMana -> CastResult.NO_MANA
            profile.isInCooldown(this) -> CastResult.IN_COOLDOWN
            SkillEvent(player, profile, this).call().not() -> CastResult.OTHER
            else -> {
                profile.refreshCooldown(this)
                profile.mana -= costMana
                if (trigger) {
                    onTrigger()
                }
                CastResult.SUCCESS
            }
        }
    }

    open fun onTrigger() {

    }
}