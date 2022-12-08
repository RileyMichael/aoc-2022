package com.github.rileymichael.day7

import com.github.rileymichael.Puzzle

sealed interface FileSystemObject {
    val size: Long
    val parent: Directory?

    class File(override val parent: Directory, override val size: Long) : FileSystemObject
    class Directory(
        override val parent: Directory?,
        var children: MutableMap<String, FileSystemObject> = mutableMapOf(),
    ) : FileSystemObject {
        override val size: Long by lazy { children.values.sumOf(FileSystemObject::size) }
    }

    fun select(selector: (FileSystemObject).() -> Boolean): List<FileSystemObject> {
        val selected = mutableListOf<FileSystemObject>()
        if (selector(this)) {
            selected += this
        }

        if (this is Directory) {
            selected += children.values.flatMap { it.select(selector) }
        }

        return selected
    }
}

object Day7: Puzzle<FileSystemObject>(7) {
    override fun parse(input: Sequence<String>): FileSystemObject {
        val root = FileSystemObject.Directory(parent = null)
        var current = root

        input.forEach { line ->
            when {
                line.startsWith("$ ls") -> { /* no op */ }
                line.startsWith("$ cd") -> {
                    val arg = line.substringAfterLast(" ")
                    current = when (arg) {
                        ".." -> current.parent ?: error("trying to cd to non existent parent dir")
                        "/" -> root
                        else -> {
                            val child = current.children[arg] ?: error ("trying to cd to non existent child $arg")
                            if (child !is FileSystemObject.Directory) {
                                error("can only cd to directories")
                            }
                            child
                        }
                    }
                }
                else -> {
                    val (left, right) = line.split(" ")
                    current.children[right] = when {
                        (left == "dir") -> FileSystemObject.Directory(current)
                        else -> FileSystemObject.File(current, left.toLong())
                    }
                }
            }
        }
        return root
    }

    override fun part1(input: FileSystemObject) = input.select {
        this is FileSystemObject.Directory && size <= 100000
    }.sumOf(FileSystemObject::size)

    override fun part2(input: FileSystemObject) = input.select {
        this is FileSystemObject.Directory && size >= (30000000 - (70000000 - input.size))
    }.minBy(FileSystemObject::size).size

}