package com.github.rileymichael.day2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day2Test : StringSpec({
    val input = """
        A Y
        B X
        C Z
    """

    "part 1 example" {
        Day2.solve(Day2::part1, input) shouldBe 15
    }

    "part 2 example" {
        Day2.solve(Day2::part2, input) shouldBe 12
    }
})