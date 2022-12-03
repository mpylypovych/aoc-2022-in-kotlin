fun main() {

    fun score(c: Char) = c - if (c.isUpperCase()) 'A' - 27 else 'a' - 1

    fun part1(input: List<String>) = input
        .map { it.chunked(it.length / 2) }
        .sumOf { row ->
            ('A'..'z').sumOf {
                if (row.first().contains(it) && row.last().contains(it))
                    score(it) else 0
            }
        }

    fun part2(input: List<String>) = input
        .map { it.toCharArray().toSet() }
        .chunked(3)
        .map {
            it.reduce { intersection, element ->
                intersection.intersect(element)
            }
        }
        .sumOf {
            score(it.first())
        }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    println(part1(testInput))
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
