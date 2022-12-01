package com.github.rileymichael.day1

import com.github.rileymichael.Puzzle


object Day1 : Puzzle<Sequence<Int>, Int>(1) {
    override fun parse(input: Sequence<String>): Sequence<Int> = input.map { it.toInt() }

    override val solutions = listOf(::part1, ::part2)

    fun part1(input: Sequence<Int>): Int = input.sum()

    fun part2(input: Sequence<Int>): Int = input.max()

}