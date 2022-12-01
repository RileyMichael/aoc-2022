package com.github.rileymichael.day1

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun `part 1 example`() {
        Day1.solve(Day1::part1, input) shouldBe 24000
    }

    @Test
    fun `part 2 example`() {
        Day1.solve(Day1::part2, input) shouldBe 45000
    }

    companion object {
        private const val input = """
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
    }
}