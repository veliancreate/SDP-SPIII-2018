package solution

object Accumulate {
    fun <T, R> accumulate(collection: List<T>, function: (T) -> R): List<R> {
        val result = mutableListOf<R>()
        for (item in collection) {
            result.add(function(item))
        }
        return result
    }
}