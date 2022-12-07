package com.github.rileymichael

import com.github.rileymichael.day1.Day1
import com.github.rileymichael.day2.Day2
import com.github.rileymichael.day3.Day3
import com.github.rileymichael.day4.Day4
import com.github.rileymichael.day5.Day5
import com.github.rileymichael.day6.Day6
import kotlin.time.measureTimedValue

fun main() {
    // todo: reflection to get rid of this.. arg to run spcific day..
    val days = listOf(
        Day1,
        Day2,
        Day3,
        Day4,
        Day5,
        Day6,
    )
    days.lastOrNull()?.run { solve() }
}

private fun <T, R> Puzzle<T, R>.solve() {
    println("Solving day $day")
    solutions.forEachIndexed { index, solution ->
        val (parse, answer) = solveTimed(solution)
        println(
            """
                - Part ${index + 1} -
                  parsed in: ${parse.duration}
                  solved in: ${answer.duration}
                  solution: ${answer.value}
            """.trimIndent()
        )
    }
}