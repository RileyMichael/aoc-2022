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
        fun left() = (0 until x).map { Point(it, y) }
        fun right() = (x + 1..width).map { Point(it, y)}
        fun up() = (0 until y).map { Point(x, it) }
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

    override fun part2(input: HeightMap): Any {
        TODO("Not yet implemented")
    }
}