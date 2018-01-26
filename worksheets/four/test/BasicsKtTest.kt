import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.*

class BasicsKtTest {
    lateinit var n: Random

    @Before
    fun start() {
        n = Random()
    }

    /**
     * The add function should return the addition of a and b
     */
    @Test
    fun addTest() {
        for (x in 1..1000) {
            val a = n.nextInt(1000)
            val b = n.nextInt(1000)
            val r = add(a, b)
            assertTrue("Your add function produced the result $r from adding $a to $b", a + b == r)
        }
    }

    /**
     * The inRange function should return an inclusive range
     */
    @Test
    fun inRangeTest() {
        for (n in 1..1000) {
            val r = inRange(1, n)
            assertTrue("The first element in your range is not 1", r.start == 1)
            for (v in r) {
                assertTrue("You have a non-odd value $v in your range", v % 2 == 1)
            }
        }
    }

    /**
     * The oddRange function should return a range of all odd integers from 1 to n"
     */
    @Test
    fun oddRangeTest() {
        for (n in 1..1000) {
            val r = oddRange(1, n)
            assertTrue("The first element in your range is not 1", r.start == 1)
            for (v in r) {
                assertTrue("You have a non-odd value $v in your range", v % 2 == 1)
            }
        }
    }

    /**
     * The minWhile function should return the minimum integer in an array using a while loop
     */
    @Test
    fun minWhileTest() {
        assertTrue(minWhile(arrayOf(55, 6, 24, 32, 1, 16, 12)) == 1)
        assertTrue(minWhile(arrayOf(2, 3, 4, 5)) == 2)
        assertTrue(minWhile(arrayOf(99, 98, 45, 100, 107, 12, 1012, 15, 45, 45, 909)) == 12)
    }

    @Test
    fun minFor() {
    }

    @Test
    fun minRecursive() {
    }

    @Test
    fun base36() {
    }

    @Test
    fun splitInHalf() {
    }

    @Test
    fun isPalindrome() {
    }

    @Test
    fun wordCounter() {
    }
}