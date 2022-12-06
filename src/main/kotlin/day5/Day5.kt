package com.github.rileymichael.day5

import com.github.rileymichael.Puzzle
import com.github.rileymichael.Solution
import com.github.rileymichael.chunkedBy


private typealias Crate = Char
private typealias Stack = ArrayDeque<Crate>
private typealias Step = Triple<Int, Int, Int>
private typealias Instructions = Pair<Array<Stack>, List<Step>>

private val pattern = "move (\\d+) from (\\d+) to (\\d+)".toRegex()
private fun String.parseStep() = pattern.matchEntire(this)?.destructured?.let { (amount, from, to) ->
    Triple(amount.toInt(), from.toInt(), to.toInt())
}

object Day5 : Puzzle<Instructions, String>(5) {
    override fun parse(input: Sequence<String>): Instructions {
        val (drawing, procedure) = input.chunkedBy(String::isBlank).toList()
        val indexes = drawing.last().mapIndexedNotNull { index, c -> if (c.isDigit()) index else null }
        val stacks = Array(indexes.size) { Stack() }

        drawing.dropLast(1).forEach { line ->
            indexes.forEachIndexed { index, i ->
                line.getOrNull(i)?.let {
                    if (it.isLetter()) stacks[index].addFirst(it)
                }
            }
        }
        val steps = procedure.mapNotNull(String::parseStep)
        return stacks to steps
    }

    override val solutions: Collection<Solution<Instructions, String>> = listOf(::part1, ::part2)

    fun part1(input: Instructions) = input.let { (stacks, steps) ->
        steps.forEach { (amount, from, to) ->
            repeat(amount) {
                val removed = stacks[from - 1].removeLast()
                stacks[to - 1].addLast(removed)
            }
        }
        stacks.map(Stack::last).joinToString("")
    }

    fun part2(input: Instructions) = input.let { (stacks, steps) ->
        steps.forEach { (amount, from, to) ->
            val removed = stacks[from - 1].takeLast(amount)
            repeat(amount) {
                stacks[from - 1].removeLast()
            }
            removed.forEach { stacks[to - 1].addLast(it) }
        }
        stacks.map(Stack::last).joinToString("")
    }

}