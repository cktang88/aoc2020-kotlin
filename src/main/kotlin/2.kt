import java.io.File

private const val fileName = "src/main/kotlin/2.txt"

data class PasswordEntry(
    val password: String,
    val range: IntRange,
    val letter: Char,
) {
    // Kotlin's replacement of "static"
    companion object {
        fun parse(line: String): PasswordEntry {
            var (_range, letter, pw) = line.split(' ')
            letter = letter.filter { it != ':' }
            val (start, end) = _range.split('-')
            return PasswordEntry(password = pw, range = start.toInt()..end.toInt(), letter = letter.first())
        }
    }

    fun validate() = password.count { it == letter } in range
    fun validatePart2() = (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)
}

fun p2part1() {
    val entries = File(fileName).readLines().map(PasswordEntry::parse)
    println(entries.count { it.validate() })
}

fun p2part2() {
    val entries = File(fileName).readLines().map(PasswordEntry::parse)
    println(entries.count { it.validatePart2() })
}