package ink.kirraobj.skyfall.character.event

import ink.kirraobj.skyfall.character.CharacterProfile
import ink.kirraobj.skyfall.character.skill.Skill
import org.bukkit.entity.Player
import taboolib.platform.type.BukkitProxyEvent

class SkillEvent(val player: Player, val profile: CharacterProfile, val skill: Skill) : BukkitProxyEvent()