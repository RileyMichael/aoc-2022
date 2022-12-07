package com.github.rileymichael.day1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day1Test : StringSpec({
    val input = """
        1000
        2000
        3000
    
        4000
    
        5000
        6000
    
        7000
        8000
        9000
    
        10000
    """

    "part 1 example" {
        Day1.solve(Day1::part1, input) shouldBe 24000
    }

    "part 1 solution" {
        Day1.solve(Day1::part1) shouldBe 68787
    }

    "part 2 example" {
        Day1.solve(Day1::part2, input) shouldBe 45000
    }

    "part 2 solution" {
        Day1.solve(Day1::part2) shouldBe 198041
    }
})