import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.KVisibility
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.starProjectedType

class TestClass {
    val readOnlyProperty: String
        get() = "Read only!"

    var readWriteString = "asd"
    var readWriteInt = 23

    var readWriteBackedStringProperty: String = ""
        get() = field + '5'
        set(value) {
            field = value + '5'
        }

    var readWriteBackedIntProperty: Int = 0
        get() = field + 1
        set(value) {
            field = value - 1
        }

    var delegatedProperty: Int by TestDelegate()

    private var privateProperty = "This should be private"

    private class TestDelegate {
        private var backingField = 3

        operator fun getValue(thisRef: Any?, prop: KProperty<*>): Int {
            return backingField
        }

        operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: Int) {
            backingField += value
        }
    }
}

fun main(args: Array<String>) {
    val instance = TestClass()
    TestClass::class.memberProperties
            .filter { prop -> prop.visibility == KVisibility.PUBLIC }
            .filterIsInstance<KMutableProperty<*>>()
            .forEach { prop ->
                println("${prop.name} -> ${prop.instanceParameter}")
            }

    TestClass::class.memberProperties
            .filter { prop -> prop.visibility == KVisibility.PUBLIC }
            // We only want strings
            .filter { it.returnType.isSubtypeOf(String::class.starProjectedType) }
            .filterIsInstance<KMutableProperty<*>>()
            .forEach { prop ->
                // Instead of printing the property we set it to some value
                prop.setter.call(instance, "Some Value")
            }
}