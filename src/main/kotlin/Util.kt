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