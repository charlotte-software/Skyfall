package ink.kirraobj.skyfall.character

import me.skymc.taskchain.TaskChain
import me.skymc.taskchain.TaskChainFactory

val taskChainFactory: TaskChainFactory
    get() = CharacterManager.taskChainFactory

val chain: TaskChain
    get() = taskChainFactory.newChain()