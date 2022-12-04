fun main() {

    fun contains(x: List<Int>, y: List<Int>) = y.all { x.first() <= it && x.last() >= it }
    fun containsAny(x: List<Int>, y: List<Int>) = y.any { x.first() <= it && x.last() >= it }

    fun solve(input: List<String>, pred : (List<Int>, List<Int>) -> Boolean) =
        input.map {
            it.split(',')
                .map {
                    it.split('-').map { it.toInt() }
                }
        }
        .sumOf { row -> if(pred(row.first(), row.last()) || pred(row.last(), row.first())) 1 else 0.toInt() }

    fun part1(input: List<String>) = solve(input, ::contains)

    fun part2(input: List<String>) = solve(input, ::containsAny)

    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
