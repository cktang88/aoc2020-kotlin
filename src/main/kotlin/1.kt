import java.io.File

fun prob1() {
    val fileName = "src/main/kotlin/1.txt"
//    File(fileName).forEachLine { println(it) }
    val nums = File(fileName).readLines().map(String::toInt)
//    var mp = nums.map { it to 2020 - it }.toMap()
    val mp = nums.associateBy { 2020 - it }

    println(mp)
//    println(mp)
    val entry = mp.filter { (_,v) -> v in mp }.firstNotNullOf{it}
    println(entry)
}

fun p1part2() {
    val fileName = "src/main/kotlin/1.txt"
//    File(fileName).forEachLine { println(it) }
    val nums = File(fileName).readLines().map(String::toInt)
}