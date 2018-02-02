import java.lang.System.exit
import kotlin.reflect.KClass

fun main(args: Array<String>){
    if (args.isEmpty()){
        println("Incorrect number of parameters: requires class name")
        exit(-1)
    }

    try {
        val cl = Class.forName(args[0])
        // print class name
        println("For class: ${cl.canonicalName}")
        println("Class modifiers: ${cl.modifiers}")
        println("Package name : ${cl.packageName}")
        // modifiers
        println("Enclosed classes:")
        cl.declaredClasses.forEach {println("\t + $it")}
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
    } catch (ex: ClassNotFoundException){
        println(ex)
    }

}

open class A

class B: A()