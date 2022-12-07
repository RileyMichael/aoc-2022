package com.github.rileymichael.day5

import com.github.rileymichael.day2.Day2
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day5Test: StringSpec({
    val input = """
            [D]    
        [N] [C]    
        [Z] [M] [P]
         1   2   3 
        
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
    """

    "part 1 example" {
        Day5.solve(Day5::part1, input) shouldBe "CMZ"
    }

    "part 1 solution" {
        Day5.solve(Day5::part1) shouldBe "ZSQVCCJLL"
    }

    "part 2 example" {
        Day5.solve(Day5::part2, input) shouldBe "MCD"
    }

    "part 2 solution" {
        Day5.solve(Day5::part2) shouldBe "QZFJRWHGS"
    }
})