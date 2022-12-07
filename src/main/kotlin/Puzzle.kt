package com.github.rileymichael

import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

typealias Solution<T, R> = (input: T) -> R

abstract class Puzzle<T, R>(val day: Int) {
    abstract fun parse(input: Sequence<String>): T

    abstract val solutions: Collection<Solution<T, R>>

    fun solve(solution: Solution<T, R>, input: String) = solution(parse(input.trimIndent().lineSequence()))

    fun solveTimed(solution: Solution<T, R>): Pair<TimedValue<T>, TimedValue<R>> =
        this::class.java.classLoader.getResourceAsStream("Day$day.txt")?.let { input ->
            input.bufferedReader().useLines {
                val parse = measureTimedValue { parse(it) }
                val answer = measureTimedValue { solution(parse.value) }
                return parse to answer
            }
        } ?: error("Input for day $day not found")
}