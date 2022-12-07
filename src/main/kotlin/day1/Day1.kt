package com.github.rileymichael.day1

import com.github.rileymichael.Puzzle
import com.github.rileymichael.chunkedBy


object Day1 : Puzzle<Sequence<Int>>(1) {
    override fun parse(input: Sequence<String>): Sequence<Int> = input
        .chunkedBy(String::isBlank)
        .map { it.sumOf(String::toInt) }
        .sortedDescending()

    override fun part1(input: Sequence<Int>) = input.first()

    override fun part2(input: Sequence<Int>) = input.take(3).sum()

}


