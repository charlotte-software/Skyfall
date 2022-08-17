package ink.kirraobj.skyfall.character

import ink.kirraobj.skyfall.character.skill.Skill
import kotlin.math.roundToInt

@Suppress("SpellCheckingInspection")
object CharacterCooldown {

    fun CharacterProfile.isInCooldown(skill: Skill): Boolean {
        val millis = cooldownMap[skill.id] ?: return false
        return millis > System.currentTimeMillis()
    }

    fun CharacterProfile.getCooldownSecs(skill: Skill): Int? {
        if (!isInCooldown(skill)) {
            return null
        }
        val secs = (cooldownMap[skill.id]!! - System.currentTimeMillis()) / 1000
        return secs.toDouble().roundToInt()
    }

    fun CharacterProfile.refreshCooldown(skill: Skill) {
        cooldownMap[skill.id] = System.currentTimeMillis() + (skill.cooldownSecs * 1000)
    }
}