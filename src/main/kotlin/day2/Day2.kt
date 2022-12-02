package com.github.rileymichael.day2

import com.github.rileymichael.Puzzle

enum class Outcome {
    Loss, Draw, Win;

    val score = ordinal * 3
}

enum class Move {
    Rock, Paper, Scissors;

    val score = ordinal + 1
}

private val Move.beatBy
    get() = Move.values()[((ordinal + 1) % 3)]

private infix fun Move.against(other: Move) = when {
    beatBy == other -> Outcome.Loss
    this == other -> Outcome.Draw
    else -> Outcome.Win
}

private fun Char.move() = when (this) {
    'A', 'X' -> Move.Rock
    'B', 'Y' -> Move.Paper
    'C', 'Z' -> Move.Scissors
    else -> error("invalid move")
}

data class Round(val opponentMove: Move, val instruction: Char)
typealias StrategyGuide = Sequence<Round>

object Day2 : Puzzle<StrategyGuide, Int>(2) {
    override fun parse(input: Sequence<String>) = input.map {
        val (left, right) = it.split(" ")
        Round(left.first().move(), right.first())
    }

    override val solutions = listOf(::part1, ::part2)

    fun part1(input: StrategyGuide) = input.sumOf { round ->
        val move = round.instruction.move()
        (move against round.opponentMove).score + move.score
    }

    fun part2(input: StrategyGuide) = input.sumOf { round ->
        val move = when (round.instruction) {
            'Z' -> round.opponentMove.beatBy
            'Y' -> round.opponentMove
            else -> Move.values().first { it.beatBy == round.opponentMove }
        }
        (move against round.opponentMove).score + move.score
    }
}