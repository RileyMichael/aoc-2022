package com.github.rileymichael.day10

import com.github.rileymichael.Puzzle


sealed interface Instruction {
    data class Add(val value: Int) : Instruction
    object NoOp : Instruction
}

private fun String.parseInstruction() = when {
    this == "noop" -> Instruction.NoOp
    startsWith("addx") -> Instruction.Add(substringAfter("addx ").toInt())
    else -> error("Unhandled instruction")
}

fun cpu(instructions: Sequence<Instruction>) = sequence {
    var register = 1
    instructions.forEach { instruction ->
        when (instruction) {
            is Instruction.Add -> {
                repeat(2) { yield(register) }
                register += instruction.value
            }
            Instruction.NoOp -> yield(register)
        }
    }
}

object Day10 : Puzzle<Sequence<Instruction>>(10) {

    override fun parse(input: Sequence<String>) = input.map(String::parseInstruction)

    override fun part1(input: Sequence<Instruction>) = cpu(input).take(220).mapIndexed { idx, register ->
        val cycle = idx + 1
        if (((cycle - 20) % 40) == 0) {
            cycle * register
        } else {
            0
        }
    }.sum()

    override fun part2(input: Sequence<Instruction>) = buildString(41 * 6) {
        cpu(input).forEachIndexed { idx, register ->
            val pos = idx % 40
            when (pos) {
                in (register - 1)..(register + 1) -> append("#")
                else -> append(".")
            }
            if (pos == 39) append("\n")
        }
    }.trim()
}