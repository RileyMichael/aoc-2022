package com.github.rileymichael.day3

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day3Test : StringSpec({
    val input = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
    """

    "part 1 example" {
        Day3.solve(Day3::part1, input) shouldBe 157
    }

    "part 1 solution" {
        Day3.solve(Day3::part1) shouldBe 7967
    }

    "part 2 example" {
        Day3.solve(Day3::part2, input) shouldBe 70
    }

    "part 2 solution" {
        Day3.solve(Day3::part2) shouldBe 2716
    }
})