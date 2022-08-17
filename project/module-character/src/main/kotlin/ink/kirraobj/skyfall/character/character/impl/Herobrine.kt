package ink.kirraobj.skyfall.character.character.impl

import ink.kirraobj.skyfall.character.character.Character
import taboolib.common.util.unsafeLazy

@Suppress("SpellCheckingInspection")
class Herobrine : Character() {

    override val id = "Herobrine"

    override val name = "HIM"

    override val skills by unsafeLazy {
        getSkills(this)
    }

    override val maxMana = 100
}