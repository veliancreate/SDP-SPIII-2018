package solution

import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class Exercise3 {
    private  lateinit var cl: Class<*>

    @Before
    fun setup(){
        cl = Class.forName("solution.Test")

    }

    // more than four fields
    @Test
    fun moreThanFourFields() {
        println(cl.declaredMethods.size)
        assertTrue(cl.declaredMethods.size > 4)
    }

    // any non-private fields
    @Test
    fun nonPrivateFields() {
        cl.declaredFields.forEach { println(it.modifiers) }
    }

    // any MutableLists
    @Test
    fun mutableLists() {
    }

    // less than two 'private' helper methods
    @Test
    fun privateHelper() {
    }

    // method has a throws clause
    @Test
    fun hasThrowsClause() {
    }

    // method returns an int
    @Test
    fun returnsAnInt() {
    }

    // missing a zero-arg cons
    @Test
    fun noArgConstructor() {
    }
}
