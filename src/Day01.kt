fun main() {
    fun split(input: List<String>) = input
        .flatMapIndexed { index, x ->
            when {
                index == 0 || index == input.lastIndex -> listOf(index)
                x.isEmpty() -> listOf(index - 1, index + 1)
                else -> emptyList()
            }
        }
        .windowed(size = 2, step = 2) { (from, to) -> input.slice(from..to) }

    fun part1(input: List<String>) = split(input)
        .maxOfOrNull { it.sumOf { it.toInt() } }

    fun part2(input: List<String>) = split(input)
        .map { it.sumOf { it.toInt() } }
        .sorted()
        .takeLast(3)
        .sum()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
