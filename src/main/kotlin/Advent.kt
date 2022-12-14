package com.github.rileymichael

import com.github.rileymichael.day1.Day1
import com.github.rileymichael.day10.Day10
import com.github.rileymichael.day2.Day2
import com.github.rileymichael.day3.Day3
import com.github.rileymichael.day4.Day4
import com.github.rileymichael.day5.Day5
import com.github.rileymichael.day6.Day6
import com.github.rileymichael.day7.Day7
import com.github.rileymichael.day8.Day8
import com.github.rileymichael.day9.Day9

fun main() {
    // todo: reflection to get rid of this.. arg to run spcific day..
    val days = listOf(
        Day1,
        Day2,
        Day3,
        Day4,
        Day5,
        Day6,
        Day7,
        Day8,
        Day9,
        Day10,
    )
    days.lastOrNull()?.run { solve() }
}

private fun <T> Puzzle<T>.solve() {
    println("----Day $day----")
    listOf(::part1, ::part2).forEachIndexed { index, solution ->
        val (parse, answer) = solveTimed(solution)
        println(
            """
- Part ${index + 1} -
parsed in: ${parse.duration}
solved in: ${answer.duration}
solution: 
${answer.value}
            """.trimIndent()
        )
    }
}