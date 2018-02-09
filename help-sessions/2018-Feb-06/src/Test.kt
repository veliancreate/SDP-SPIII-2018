import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmErasure

class Test {
    constructor(b: String)

    constructor(a: Int)

}


fun main(args: Array<String>) {
    val kc: KClass<*> = Test::class
    kc.constructors.forEach {
        it.parameters.forEach {
            when (it.type.jvmErasure) {
                Int::class -> println("Int")
                String::class -> println("String")
            }
        }
    }
}