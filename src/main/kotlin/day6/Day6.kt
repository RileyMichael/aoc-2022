package com.github.rileymichael.day6

import com.github.rileymichael.Puzzle

object Day6 : Puzzle<String, Int>(6) {
    override fun parse(input: Sequence<String>) = input.single()

    override val solutions = listOf(::part1, ::part2)

    private fun detect(buffer: String, windowSize: Int) = buffer
        .windowedSequence(windowSize) { it.toSet() }
        .indexOfFirst { it.size == windowSize } + windowSize

    fun part1(input: String) = detect(input, 4)
    fun part2(input: String) = detect(input, 14)
}