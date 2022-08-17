package ink.kirraobj.skyfall.character

import ink.kirraobj.skyfall.character.character.Character
import me.skymc.taskchain.TaskChainFactory
import taboolib.common.LifeCycle
import taboolib.common.io.getInstance
import taboolib.common.io.runningClasses
import taboolib.common.platform.Awake

object CharacterManager {

    lateinit var characters: MutableMap<String, Character>

    lateinit var taskChainFactory: TaskChainFactory

    @Awake(LifeCycle.ENABLE)
    fun i() {
        characters = runningClasses
            .filter { it.isAssignableFrom(Character::class.java) && it != Character::class.java }
            .map { it.getInstance(newInstance = true) as Character }
            .associateBy { it.id }
            .toMutableMap()
    }
}