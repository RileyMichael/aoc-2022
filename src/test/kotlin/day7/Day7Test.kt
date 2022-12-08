package day7

import com.github.rileymichael.day7.Day7
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day7Test: StringSpec({
    val input = """
        $ cd /
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $ cd a
        $ ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $ cd e
        $ ls
        584 i
        $ cd ..
        $ cd ..
        $ cd d
        $ ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
    """.trimIndent()

    "part 1 example" {
        Day7.solve(Day7::part1, input) shouldBe 95437
    }

    "part 2 example" {
        Day7.solve(Day7::part2, input) shouldBe 24933642
    }
})