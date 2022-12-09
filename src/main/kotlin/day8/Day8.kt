package com.github.rileymichael.day8

import com.github.rileymichael.Puzzle

data class HeightMap(private val grid: List<List<Int>>) {
    private val height = grid.lastIndex
    private val width = grid.first().lastIndex
    val points by lazy {
        (0..width).map { x ->
            (0..height).map { y ->
                Point(x, y)
            }
        }
    }

    operator fun get(point: Point) = grid[point.y][point.x]

    inner class Point(val x: Int, val y: Int) {
        fun visible(others: List<Point>) = others.all {
            this@HeightMap[it] < this@HeightMap[this]
        }

        fun viewDistance(others: List<Point>) = minOf(others.takeWhile {
            this@HeightMap[it] < this@HeightMap[this]
        }.size + 1, others.size) // we need to account for the blocked tree

        fun left() = (x - 1 downTo 0).map { Point(it, y) }
        fun right() = (x + 1..width).map { Point(it, y) }
        fun up() = (y - 1 downTo 0).map { Point(x, it) }
        fun down() = (y + 1..height).map { Point(x, it) }
    }
}

object Day8 : Puzzle<HeightMap>(8) {
    override fun parse(input: Sequence<String>) = input.map {
        it.map(Char::digitToInt)
    }.toList().run(::HeightMap)

    override fun part1(input: HeightMap) = input.points.flatten().count {
        it.visible(it.left()) || it.visible(it.right()) || it.visible(it.up()) || it.visible(it.down())
    }

    override fun part2(input: HeightMap) = input.points.flatten().maxOf {
        it.viewDistance(it.up()) *
        it.viewDistance(it.left()) *
        it.viewDistance(it.right()) *
        it.viewDistance(it.down())
    }
}