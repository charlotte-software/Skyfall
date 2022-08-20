package ink.kirraobj.skyfall.character.character

import ink.kirraobj.skyfall.character.skill.Skill
import ink.kirraobj.skyfall.character.skill.adapter.impl.AdapterCharacter
import taboolib.common.io.getInstance
import taboolib.common.io.runningClasses

abstract class Character {

    abstract val id: String

    abstract val name: String

    abstract val skills: List<Skill>

    abstract val maxMana: Int

    companion object {

        fun getSkills(character: Character): List<Skill> {
            return runningClasses
                .filter { Skill::class.java.isAssignableFrom(it.javaClass) && it != Skill::class.java }
                .map { it.getInstance() as Skill }
                .filter {
                    val adapter = it as? AdapterCharacter ?: return@filter true
                    return@filter adapter.character == character
                }
                .toCollection(mutableListOf())
        }
    }
}