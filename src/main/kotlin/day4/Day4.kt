package com.github.rileymichael.day4

import com.github.rileymichael.Puzzle
import java.lang.Integer.max
import java.lang.Integer.min


private typealias Assignment = IntRange
private typealias AssignmentPair = Pair<Assignment, Assignment>

private val AssignmentPair.fullyContained: Boolean
    get() = run {
        val range = min(first.first, second.first)..max(first.last, second.last)
        range == first || range == second
    }

private val AssignmentPair.overlap: Boolean
    get() = first.first in second || second.first in first

private fun String.toAssignment() = split("-", limit = 2)
    .map(String::toInt)
    .run { first()..last() }

object Day4 : Puzzle<Sequence<AssignmentPair>>(4) {
    override fun parse(input: Sequence<String>) = input.map {
        val assignments = it.split(",", limit = 2)
        assignments.map(String::toAssignment).run {
            first() to last()
        }
    }

    override fun part1(input: Sequence<AssignmentPair>) = input.count(AssignmentPair::fullyContained)

    override fun part2(input: Sequence<AssignmentPair>) = input.count(AssignmentPair::overlap)
}