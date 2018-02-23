fun main(args: Array<String>) {

    val mf = memo(::fib)
    println(mf(10))
    println(mf(10))

    val memolength = memo { xs: List<Int> ->
        println("Computing...")
        xs.size
    }

    println(memolength(listOf<Int>(1, 2, 3, 4, 5, 6, 7)))
    println(memolength(listOf<Int>(1, 2, 3, 4, 5, 6, 7)))
}
