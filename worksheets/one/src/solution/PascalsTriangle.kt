package solution

object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        require(rows >= 0, { "Rows can't be negative!" })

        if (rows == 0) return emptyList()
        return (1..rows).map { buildTriangleRow(it) }
    }

    private fun buildTriangleRow(row: Int): List<Int> {
        var m = 1
        return listOf(1) + (1 until row).map { col ->
            m = m * (row - col) / col
            return@map m // just another feature of the langauge - not necessarily a good one though!
        }
    }
}