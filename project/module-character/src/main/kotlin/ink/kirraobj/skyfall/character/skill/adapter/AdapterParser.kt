package ink.kirraobj.skyfall.character.skill.adapter

import ink.kirraobj.skyfall.character.skill.Skill

object AdapterParser {

    inline fun <reified T> parse(skill: Skill): T? {
        return when (skill) {
            is T -> skill
            else -> null
        }
    }
}