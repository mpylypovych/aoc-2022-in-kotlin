fun main() {
    fun isDraw(a: Char, b: Char) = a - 'A' == b -'X'
    fun isWin(a: Char, b: Char) : Boolean {
        val opponent = a - 'A'
        val my = b - 'X'
        return (my - opponent == 1) || (my == 0 && opponent == 2)
    }
    fun score(a: Char) = a.minus('X') + 1

    fun part1(input: List<String>) = input
        .sumOf {
            when {
                isDraw(it.first(), it.last()) -> 3 + score(it.last())
                isWin(it.first(), it.last()) -> 6 + score(it.last())
                else -> score(it.last())
            }
        }

    fun solve(input: String) = when (input.last()) {
        'X' -> (input.first() - 'A' + 2) % 3 + 1
        'Y' -> input.first() - 'A' + 1
        else -> (input.first() -'A' + 1) % 3 + 1
    }

    fun part2(input: List<String>) = input.sumOf { solve(it) + it.last().minus('X') * 3 }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    println(part1(testInput))
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
