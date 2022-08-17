package ink.kirraobj.skyfall.character.skill

import ink.kirraobj.skyfall.character.character.Character

interface CharacterSkill {

    val type: SkillType

    val character: Character
}