class Deque<T> {
    private var head: Element<T>? = null

    fun push(value: T) {
        // TODO
    }

    fun pop(): T? {
        // TODO
        return shift()
    }

    fun unshift(value: T) {
        // TODO
    }

    fun shift(): T? {
        val value = head?.value
        // TODO
        return value
    }

    private data class Element<T>(val value: T, var prev: Element<T>? = null, var next: Element<T>? = null)
}