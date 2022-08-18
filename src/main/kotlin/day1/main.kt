package day1

import java.io.File

private const val SUM = 2020
private const val fileName = "src/main/kotlin/day1/input.txt"

private fun part1() {
//    File(fileName).forEachLine { println(it) }
    val nums = File(fileName).readLines().map(String::toInt)
//    var mp = nums.map { it to 2020 - it }.toMap()
    val mp = nums.associateBy { SUM - it }

    println(mp)
    val entry = mp.filter { (_, v) -> v in mp }.firstNotNullOf { it }
    println(entry.let { (a, b) -> a * b })
}

private fun part2() {

    fun List<Int>.getPair(sum: Int): Map.Entry<Int, Int>? {
        val mp = associateBy { sum - it }
        return mp.filter { (_, v) -> v in mp }.firstNotNullOfOrNull { it }
    }

    val nums = File(fileName).readLines().map(String::toInt)
    val mp = nums.associateWith { nums.getPair(SUM - it) }
    val entry = mp.filter { (_, v) -> v != null }.firstNotNullOf { it }
    // hacky assert
    println(entry.let { (k, v) -> k * v!!.key * v.value })
}

fun main() {
    part1()
    part2()
}