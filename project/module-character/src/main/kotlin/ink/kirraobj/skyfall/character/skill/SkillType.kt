package ink.kirraobj.skyfall.character.skill

enum class SkillType {

    /**
     * 主技能 (玩家右键任一剑触发)
     */
    MAIN,

    /**
     * 被动技能 (玩家右键任一弓触发)
     */
    SUB,

    /**
     * 被动技能 (满足条件触发)
     */
    PASSIVE;
}