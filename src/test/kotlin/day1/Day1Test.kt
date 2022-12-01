package com.github.rileymichael.day1

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun `part 1 example`() {
        val input = """
            1
            2
        """.trimIndent()
        Day1.solve(Day1::part1, input) shouldBe 3
    }

    @Test
    fun `part 2 example`() {
        val input = """
            1
            2
        """.trimIndent()
        Day1.solve(Day1::part2, input) shouldBe 2
    }
}