package ink.kirraobj.skyfall.character

import com.google.gson.*
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.deserializeToItemStack
import taboolib.platform.util.serializeToByteArray
import java.lang.reflect.Type

@Suppress("ArrayInDataClass")
data class Kit(val contents: Array<ItemStack>, val armorContents: Array<ItemStack>) {

    val helmet: ItemStack
        get() = armorContents[0]

    val chestPlate: ItemStack
        get() = armorContents[1]

    val leggings: ItemStack
        get() = armorContents[2]

    val boots: ItemStack
        get() = armorContents[3]

    fun serialized(): String {
        return gson.toJson(this)
    }

    companion object {

        val gson = GsonBuilder()
            .registerTypeAdapter(Kit::class.java, KitAdapter.javaClass)
            .create()!!

        fun deserialized(str: String): Kit {
            return gson.fromJson(str, Kit::class.java)
        }

        object KitAdapter : JsonSerializer<Kit>, JsonDeserializer<Kit> {

            override fun serialize(kit: Kit, type: Type, context: JsonSerializationContext): JsonElement {
                return JsonObject().apply {
                    val contentsZipped = kit.contents.map { it.serializeToByteArray(zipped = true) }
                    val armorContentsZipped = kit.armorContents.map { it.serializeToByteArray(zipped = true) }
                    addProperty("contents", gson.toJson(contentsZipped))
                    addProperty("armorContents", gson.toJson(armorContentsZipped))
                }
            }

            override fun deserialize(jsonElement: JsonElement, type: Type, context: JsonDeserializationContext): Kit {
                val obj = jsonElement.asJsonObject
                val contents = gson.fromJson<List<ByteArray>>(obj.get("contents"), Kit::class.java)
                    .map { it.deserializeToItemStack(zipped = true) }
                    .toTypedArray()
                val armorContents = gson.fromJson<List<ByteArray>>(obj.get("armorContents"), Kit::class.java)
                    .map { it.deserializeToItemStack(zipped = true) }
                    .toTypedArray()
                return Kit(contents, armorContents)
            }
        }
    }
}