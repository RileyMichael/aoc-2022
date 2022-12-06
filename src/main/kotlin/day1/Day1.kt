package com.github.rileymichael.day1

import com.github.rileymichael.Puzzle
import com.github.rileymichael.chunkedBy


object Day1 : Puzzle<Sequence<Int>, Int>(1) {
    override fun parse(input: Sequence<String>): Sequence<Int> = input
        .chunkedBy(String::isBlank)
        .map { it.sumOf(String::toInt) }
        .sortedDescending()

    override val solutions = listOf(::part1, ::part2)

    fun part1(input: Sequence<Int>): Int = input.first()

    fun part2(input: Sequence<Int>): Int = input.take(3).sum()

}


