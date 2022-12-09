package com.github.rileymichael.day8

import com.github.rileymichael.day7.Day7
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day8Test : StringSpec({
    val input = """
        30373
        25512
        65332
        33549
        35390
    """.trimIndent()

    "part 1 example" {
        Day8.solve(Day8::part1, input) shouldBe 21
    }

    "part 2 example" {
        Day8.solve(Day8::part2, input) shouldBe 8
    }
})
