package com.github.rileymichael.day9

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day9Test : StringSpec({
    val input = """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
    """.trimIndent()

    "part 1 example" {
        Day9.solve(Day9::part1, input) shouldBe 13
    }

    "part 1 solution" {
        Day9.solve(Day9::part1) shouldBe 5883
    }

    "part 2 example" {
        Day9.solve(Day9::part2, input) shouldBe 1
    }

    "part 2 larger example" {
        val largerInput = """
            R 5
            U 8
            L 8
            D 3
            R 17
            D 10
            L 25
            U 20
        """.trimIndent()
        Day9.solve(Day9::part2, largerInput) shouldBe 36
    }

    "part 2 solution" {
        Day9.solve(Day9::part2) shouldBe 2367
    }
})
