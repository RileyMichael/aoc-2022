package com.github.rileymichael

typealias Solution<T, R> = (input: T) -> R

abstract class Puzzle<T, R>(val day: Int) {
    abstract fun parse(input: Sequence<String>): T

    abstract val solutions: Collection<Solution<T, R>>

    fun solve(solution: Solution<T, R>, input: String) = solution(parse(input.trimIndent().lineSequence()))

    fun solve(solution: Solution<T, R>, input: T) = solution(input)
}