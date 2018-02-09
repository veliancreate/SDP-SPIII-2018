import java.lang.System.exit
import java.lang.reflect.Constructor
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberExtensionFunctions
import kotlin.reflect.full.superclasses

// So as not to "give away" the coursework this set of "solutions" only deal with Java classes.
// One needs to handle KClass for the coursework assignment.

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Incorrect number of parameters: requires class name")
        exit(-1)
    }

    fun1(args[0])
    fun2(args)

}

fun fun1(className: String) {
    try {
        val cl = Class.forName(className)
        // print class name
        println("For class: ${cl.canonicalName}")
        println("Class modifiers: ${cl.modifiers}")
        println("Package name : ${cl.packageName}")
        // modifiers
        println("Enclosed classes:")
        cl.declaredClasses.forEach { println("\t + $it") }
        // constructors
        println("Constructors:")
        cl.constructors.forEach { println("\t + $it") }
        // fields
        println("Fields:")
        cl.declaredFields.forEach { println("\t + $it") }
        // methods
        println("Methods:")
        cl.declaredMethods.forEach { println("\t + $it") }
        // etc.
        println("Implementing interfaces:")
        cl.genericInterfaces.forEach { println("\t + $it") }
        println("---------------------------")
    } catch (ex: ClassNotFoundException) {
        println(ex)
    }
}

fun fun2(args: Array<String>) {

    try {
        val cl = Class.forName(args[0])
        val params = args.drop(1)
        val x = cl.constructors.filter { it.parameterCount == params.size }
        val item = x[0].newInstance(*parameters(x[0], params))
        println(item)
    } catch (ex: ClassNotFoundException) {
        println(ex)
    }
}

/**
 * convert to array of correct types
 */
fun parameters(cons: Constructor<*>, params: List<String>): Array<Any?> {
    val fields = cons.parameterTypes
    val array = arrayOfNulls<Any>(params.size)

    fields.forEachIndexed({ index, item ->
        array[index] = when (item) {
            Int::class.java -> Integer(params[index])
            Boolean::class.java -> when (params[index]) {
                "true" -> true
                else -> false
            }
            else -> params[index]
        }
    })
    return array
}

fun fun3() {} // see the "test" directory for indications on how to approach this problem.

fun fun4(obj: Any) {
    // using an extension function to add/replace toString to Object/Any
    // Alternatively write a toString method which takes any object and then reflects on it.
    val cl = obj::class
    // and then very similar to the above
    println("For class: ${cl.qualifiedName}")
    println("Simple name: ${cl.simpleName}")
    println("Super types: ")
    cl.supertypes.forEach { println(it) }
    println("Supre classes:")
    cl.superclasses.forEach { println(it) }
    println("Constructors:")
    cl.constructors.forEach { println(it) }
    if (cl.isAbstract) println("Abstract class")
    if (cl.isData) println("Data class")
    // etc.
    println("Generic type parameters")
    cl.typeParameters.forEach { println(it) }

    println("Declared functions")
    cl.declaredFunctions.forEach { println(it) }
    println("Extenxion functions")
    cl.declaredMemberExtensionFunctions.forEach { println(it) }
    // etc.
}


data class Example(val i: Int, val s: String = "abcd", var b: Boolean = false) {
    constructor(i: Int, s: String) : this(i)
}

open class A

class B : A()

fun A.extensionFunction(){}