package ink.kirraobj.skyfall.character.character

import ink.kirraobj.skyfall.character.skill.CharacterSkill
import ink.kirraobj.skyfall.character.skill.Skill
import taboolib.common.io.getInstance
import taboolib.common.io.runningClasses

abstract class Character {

    abstract val id: String

    abstract val name: String

    abstract val skills: List<Skill>

    abstract val maxMana: Int

    companion object {

        fun getSkills(character: Character): List<Skill> {
            val toReturn = mutableListOf<Skill>()
            runningClasses
                .filter { Skill::class.java.isAssignableFrom(it.javaClass) && it != Skill::class.java }
                .forEach {
                    if (CharacterSkill::class.java.isAssignableFrom(it.javaClass) && it != CharacterSkill::class.java) {
                        val instance = it.getInstance() as CharacterSkill
                        if (instance.character == character) {
                            toReturn += instance as Skill
                        }
                        return@forEach
                    }
                    toReturn += it.getInstance() as Skill
                }
            return toReturn
        }
    }
}