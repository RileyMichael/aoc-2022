package com.github.rileymichael.day6

import com.github.rileymichael.day5.Day5
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day6Test : StringSpec({
    val partOneInput = listOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 7,
        "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
        "nppdvjthqldpwncqszvftbrmjlhg" to 6,
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11,
    )

    partOneInput.forEachIndexed { index, pair ->
        "part 1 example $index" {
            Day6.solve(Day6::part1, pair.first) shouldBe pair.second
        }
    }

    "part 1 solution" {
        Day6.solve(Day6::part1) shouldBe 1531
    }

    val partTwoInput = listOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 19,
        "bvwbjplbgvbhsrlpgdmjqwftvncz" to 23,
        "nppdvjthqldpwncqszvftbrmjlhg" to 23,
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 29,
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 26,
    )

    partTwoInput.forEachIndexed { index, pair ->
        "part 2 example $index" {
            Day6.solve(Day6::part2, pair.first) shouldBe pair.second
        }
    }

    "part 2 solution" {
        Day6.solve(Day6::part2) shouldBe 2518
    }
})