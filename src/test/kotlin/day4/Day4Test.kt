package day4

import com.github.rileymichael.day4.Day4
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day4Test: StringSpec({
    val input = """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
    """

    "part 1 example" {
        Day4.solve(Day4::part1, input) shouldBe 2
    }

    "part 2 example" {
        Day4.solve(Day4::part2, input) shouldBe 4
    }
})