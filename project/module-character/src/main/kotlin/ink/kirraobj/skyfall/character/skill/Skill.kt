package ink.kirraobj.skyfall.character.skill

import ink.kirraobj.skyfall.character.CharacterCooldown.isInCooldown
import ink.kirraobj.skyfall.character.CharacterCooldown.refreshCooldown
import ink.kirraobj.skyfall.character.CharacterProfile
import ink.kirraobj.skyfall.character.event.SkillEvent
import ink.kirraobj.skyfall.character.skill.adapter.AdapterParser
import ink.kirraobj.skyfall.character.skill.adapter.impl.AdapterMana
import org.bukkit.entity.Player

abstract class Skill {

    abstract val id: String

    abstract val name: String

    @Suppress("SpellCheckingInspection")
    abstract val cooldownSecs: Int

    fun cast(player: Player, trigger: Boolean = true): CastResult {
        val profile = CharacterProfile.getByPlayer(player) ?: return CastResult.OTHER
        val costMana = AdapterParser.parse<AdapterMana>(this)?.costMana ?: 0
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