package com.github.rileymichael

fun <T> Sequence<T>.chunkedBy(predicate: (T) -> Boolean): Sequence<List<T>> = sequence {
    val chunk = mutableListOf<T>()
    this@chunkedBy.forEach { curr ->
        val split = predicate(curr)
        if (split) {
            yield(chunk.toList())
            chunk.clear()
        } else {
            chunk.add(curr)
        }
    }
    if (chunk.isNotEmpty()) {
        yield(chunk)
    }
}

open class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    override fun toString() = "($x,$y)"

}