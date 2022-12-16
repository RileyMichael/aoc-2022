package com.github.rileymichael.day8

import com.github.rileymichael.Point
import com.github.rileymichael.Puzzle

data class HeightMap(private val grid: List<List<Int>>) {
    private val height = grid.lastIndex
    private val width = grid.first().lastIndex
    val trees by lazy {
        (0..width).map { x ->
            (0..height).map { y ->
                Tree(x, y)
            }
        }
    }

    operator fun get(tree: Tree) = grid[tree.y][tree.x]

    inner class Tree(x: Int, y: Int) : Point(x, y) {
        fun visible(others: List<Tree>) = others.all {
            this@HeightMap[it] < this@HeightMap[this]
        }

        fun viewDistance(others: List<Tree>) = minOf(others.takeWhile {
            this@HeightMap[it] < this@HeightMap[this]
        }.size + 1, others.size) // we need to account for the blocked tree

        fun left() = (x - 1 downTo 0).map { Tree(it, y) }
        fun right() = (x + 1..width).map { Tree(it, y) }
        fun up() = (y - 1 downTo 0).map { Tree(x, it) }
        fun down() = (y + 1..height).map { Tree(x, it) }
    }
}

object Day8 : Puzzle<HeightMap>(8) {
    override fun parse(input: Sequence<String>) = input.map {
        it.map(Char::digitToInt)
    }.toList().run(::HeightMap)

    override fun part1(input: HeightMap) = input.trees.flatten().count {
        it.visible(it.left()) || it.visible(it.right()) || it.visible(it.up()) || it.visible(it.down())
    }

    override fun part2(input: HeightMap) = input.trees.flatten().maxOf {
        it.viewDistance(it.up()) *
        it.viewDistance(it.left()) *
        it.viewDistance(it.right()) *
        it.viewDistance(it.down())
    }
}