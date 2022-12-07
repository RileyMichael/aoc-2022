package com.github.rileymichael.day6

import com.github.rileymichael.Puzzle

object Day6: Puzzle<Sequence<Set<Char>>, Int>(6) {
    private const val windowSize = 4
    override fun parse(input: Sequence<String>) = input.single().windowedSequence(windowSize) { it.toSet()}

    override val solutions = listOf(::part1)

    fun part1(input: Sequence<Set<Char>>) = input.indexOfFirst { it.size == windowSize } + windowSize
}