import junit.framework.Assert.assertEquals
import org.junit.Test

class FunctionsTest {

    @Test // "Tail removes the first element"
    fun removeTest() {
        assert(tail(listOf(1, 2, 3, 4)) == listOf(2, 3, 4))
    }

    @Test // "setHead changes the first element of the listOf"
    fun setHeadTest() {
        assert(setHead(listOf("A", "B", "C"), "0") == listOf("0", "B", "C"))
    }

    @Test // "drop removes N elements from the front of the listOf"
    fun dropTest() {
        assert(drop(listOf(1, 2, 3), 2) == listOf(3))
    }

    @Test // "init removes the last element"
    fun initTest() {
        assert(init(listOf("A", "B", "C", "D")) == listOf("A", "B", "C"))
    }

    // Folding
    @Test // "foldLeft computes the correct value"
    fun foldLeftTest() {
        assertEquals("Hello",foldLeft(listOf("H", "e", "l", "l", "o"), "", {x,y -> x + y}))
    }

    @Test // "sum produces the correct sum"
    fun sumTest() {
        assert(sum(listOf(1.0, 2.0, 3.0, -3.0, -2.0, -1.0)) == 0.0)
    }

    @Test // "product produces the correct product"
    fun productTest() {
        assert(product(listOf(1.0, 2.0, 3.0, 4.0, 5.0)) == 120.0)
    }

    @Test // "length calculates the length"
    fun lengthTest() {
        assertEquals(5, length("Hello".toList()))
    }

    @Test // "reverse reverses the listOf"
    fun reverseTest() {
        assertEquals("olleH".toList(), reverse("Hello".toList()))
    }

    @Test // "flatten flattens the nested listOf"
    fun flattenTest() {
        assert(flatten(listOf(listOf(1, 2, 3), listOf(4, 5, 6))) == listOf(1, 2, 3, 4, 5, 6))
    }

    // Map and Filter
    @Test // "map creates a new listOf of the correct values"
    fun mapTest() {
        assertEquals((2 to 11).toList(), map((1 to 10).toList(), { x -> x + 1 }))
    }

    @Test // "filter filters the listOf"
    fun filterTest() {
        assertEquals((1 to 5).toList(), filter((-5 to 5).toList(), { x: Int -> x > 0 }))
    }

    @Test // "flatMap maps and flattens"
    fun flatMapTest() {
        assertEquals(listOf(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5),
                flatMap((1 to 5).toList(), { x -> (x to 5).toList() }))
    }

    // Combined

    @Test // "maxAverage calculates the max average"
    fun maxAverageTest() {
        val listof = listOf(Triple(1.0,2.5,3.0), Triple(4.5,5.0,6.0), Triple(4.0,3.25,4.0))
        assertEquals(4.33, maxAverage(listof), 0.01)
    }

    @Test // "variance calculates the correct variance"
    fun varianceTest() {
        val v = variance(listOf(1.0, 2.0, 3.0, 4.0, 5.0))
        assertEquals("If you got 2.5, you divided by the wrong thing, probably.", 2.0, v, 0.01)
    }
}
