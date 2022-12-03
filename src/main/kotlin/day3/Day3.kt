package com.github.rileymichael.day3

import com.github.rileymichael.Puzzle

typealias Item = Char

val Item.priority
    get() = when {
        isUpperCase() -> code - 'A'.code + 27
        else -> code - 'a'.code + 1
    }

typealias Compartment = Set<Item>
typealias Rucksack = Pair<Compartment, Compartment>

object Day3 : Puzzle<Sequence<Rucksack>, Int>(3) {
    override fun parse(input: Sequence<String>) = input.map {
        val (first, second) = it.chunked(it.length / 2)
        first.toSet() to second.toSet()
    }

    override val solutions = listOf(::part1, ::part2)

    fun part1(input: Sequence<Rucksack>) = input.sumOf { sack ->
        val both = sack.first.intersect(sack.second)
        both.sumOf(Item::priority)
    }

    fun part2(input: Sequence<Rucksack>): Int = input.chunked(3).sumOf { sacks ->
        val (one, two, three) = sacks.map { (it.first + it.second) }
        val badge = one.intersect(two).intersect(three).first()
        badge.priority
    }
}