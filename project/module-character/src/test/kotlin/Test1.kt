object Test1 {

    abstract class AbstractA

    interface InterfaceA

    class ClazzA : AbstractA(), InterfaceA

    class ClazzB : AbstractA()

    @JvmStatic
    fun main(args: Array<String>) {

        val instanceA = ClazzA()
        val instanceB = ClazzB()
        println(InterfaceA::class.java.isAssignableFrom(instanceB.javaClass))
    }
}