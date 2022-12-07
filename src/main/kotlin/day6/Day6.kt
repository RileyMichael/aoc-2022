package com.github.rileymichael.day6

import com.github.rileymichael.Puzzle

object Day6 : Puzzle<String>(6) {
    override fun parse(input: Sequence<String>) = input.single()

    private fun detect(buffer: String, windowSize: Int) = buffer
        .windowedSequence(windowSize) { it.toSet() }
        .indexOfFirst { it.size == windowSize } + windowSize

    override fun part1(input: String) = detect(input, 4)
    override fun part2(input: String) = detect(input, 14)
}