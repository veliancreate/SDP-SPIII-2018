package altreflect

import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier

class Spy private constructor(var thisClass: Class<*>) {
    var className: String
    var fields: Array<Field>
    var methods: Array<Method>
    var atBeginningOfLine: Boolean = false
    var level = 0
    var aaaaa: String
    internal var packageInt: Int = 0

    init {
        atBeginningOfLine = true
        aaaaa = "Not used, really."
    }

    init {
        className = thisClass.name
    }

    @Throws(ClassNotFoundException::class)
    private constructor(className: String) : this(Class.forName(className)) {
    }

    internal fun printAll(args: Array<String>) {
        println("----------------------------")
        if (args.size == 0) {
            printClass()
        } else {
            assert(args.size > 0)
            for (str in args) {
                try {
                    val s = Spy.getSpy(str)
                    s.printClass()
                } catch (e: ClassNotFoundException) {
                    level = 0
                    write("\nClass not found: " + str)
                }

            }
        }
    }

    fun write(s: String) {
        if (atBeginningOfLine) {
            for (i in 0 until level % 10) {
                print("   ")
            }
            atBeginningOfLine = false
        }
        print(s)
    }

    fun writeln(s: String) {
        write(s)
        println()
        atBeginningOfLine = true
    }

    fun indent() {
        level++
    }

    fun exdent() {
        level--
    }

    fun printClass() {
        printClassHeader()
        printFields()
        printMethods()
        printClassCloser()
    }

    @Throws(SecurityException::class)
    private fun printMethods() {
        methods = thisClass.methods
        writeln("// Methods:")
        indent()
        for (m in methods) {
            if (thisClass == m.declaringClass) {
                printMethod(m)
            }
        }
        exdent()
    }

    internal fun printClassHeader() {
        val sc = thisClass.superclass
        val classModifiers = thisClass.modifiers

        write(Modifier.toString(classModifiers))
        write(" class ")
        write(className)
        if (sc.name !== "java.lang.Object") {
            write(" extends " + sc.name)
        }
        val interfaces = thisClass.interfaces
        if (interfaces.size > 0) {
            write(" implements")
            for (i in interfaces.indices) {
                write(if (i == 0) " " else ", ")
                write(interfaces[i].name)
            }
        }
        writeln(" {")
        indent()
    }

    private fun printClassCloser() {
        exdent()
        writeln("}")
    }

    internal fun printFields() {
        fields = thisClass.fields
        writeln("// Fields:")
        indent()
        for (f in fields) {
            printField(f)
        }
        exdent()
    }

    fun printField(field: Field) {
        val modifiers = field.modifiers
        write(Modifier.toString(modifiers) + " ")
        write(decodeType(field.type.name))
        write(" " + field.name + ";")
        val declaredIn = field.declaringClass.name
        if (className != declaredIn) {
            write("  // inherited from " + declaredIn)
        }
        writeln("")
    }

    fun decodeType(typeCode: String): String {
        // horrible code!!
        var arrayLevel = 0
        var brackets = ""
        while (typeCode[arrayLevel] == '[') {
            arrayLevel++
            brackets += "[]"
        }
        // probably should use a hashmap or something similar...
        when (typeCode[arrayLevel]) {
            'B' -> return "byte" + brackets
            'C' -> return "char" + brackets
            'D' -> return "double" + brackets
            'F' -> return "float" + brackets
            'I' -> return "int" + brackets
            'J' -> return "long" + brackets
            'S' -> return "short" + brackets
            'Z' -> return "boolean" + brackets
            'V' -> return "void" + brackets
            'L' -> return simplifyName(typeCode) + brackets
            else -> return typeCode + brackets
        }
    }

    fun printMethod(method: Method) {
        write(Modifier.toString(method.modifiers) + " ")
        write(decodeType(method.returnType.name))
        write(" " + method.name + "(")
        printParameters(method.parameterTypes)
        writeln(") { }")
    }

    fun printParameters(parameters: Array<Class<*>>) {
        if (parameters.size == 0)
            return
        write(decodeType(parameters[0].name))
        for (cl in parameters) {
            write(", " + simplifyName(decodeType(cl.name)))
            write("[" + decodeType(cl.name) + "]")
        }
    }

    fun simplifyName(name: String): String {
        val last = name.lastIndexOf(".") + 1
        return if (last < 0) name else name.substring(last, name.length - 1)
    }

    companion object {
        private val serialVersionUID: Long

        init {
            serialVersionUID = 1L
        }

        internal fun getSpy(c: Class<*>): Spy {
            return Spy(c)
        }

        @Throws(ClassNotFoundException::class)
        internal fun getSpy(className: String): Spy {
            return Spy(className)
        }

        fun printInfo(field: Field) {
            println("    " + field.name)
            val modifiers = field.modifiers
            println("        Modifiers: " + modifiers)
            println("        Type:      " + field.type.name)
        }

        fun myGetType(obj: Any): String {
            return "Not implemented."
        }
    }
}