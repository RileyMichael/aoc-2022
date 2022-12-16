package com.github.rileymichael.day9

import com.github.rileymichael.Point
import com.github.rileymichael.Puzzle
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sign


private val directions = mapOf(
    "U" to Point(0, 1),
    "D" to Point(0, -1),
    "R" to Point(1, 0),
    "L" to Point(-1, 0)
)

private typealias Motion = Pair<Point, Int>

private fun Point.delta(other: Point) = Point(x - other.x, y - other.y)
private val Point.abs
    get() = Point(abs(x), abs(y))

object Day9 : Puzzle<Sequence<Motion>>(9) {
    override fun parse(input: Sequence<String>) = input.map {
        val (dir, steps) = it.split(" ")
        val move = directions[dir] ?: error("invalid input")
        move to steps.toInt()
    }

    override fun part1(input: Sequence<Motion>): Int = simulate(input, 2).last().toSet().size

    override fun part2(input: Sequence<Motion>) = simulate(input, 10).last().toSet().size

    private fun simulate(motions: Sequence<Motion>, knots: Int): List<MutableList<Point>> {
        // there probably isn't a need to track every single move for every knot but..
        val rope = List(knots) { mutableListOf(Point(0, 0)) }
        val headPositions = rope.first()
        motions.forEach { (direction, times) ->
            repeat(times) {
                headPositions += headPositions.last() + direction
                rope.windowed(2).forEach { (prevPositions, currentPositions) ->
                    val curr = currentPositions.last()
                    val prev = prevPositions.last()
                    val delta = prev.delta(curr)
                    if (delta.abs.run { max(x, y) } > 1) {
                        currentPositions += Point(curr.x + delta.x.sign, curr.y + delta.y.sign)
                    }
                }
            }
        }
        return rope
    }
}
