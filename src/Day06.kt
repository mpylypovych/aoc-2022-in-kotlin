fun main() {

    fun solve(input: String, size: Int) = input.windowed(size, 1).indexOfFirst { it.toSet().size == size } + size

    fun part1(input: String) = solve(input, 4)

    fun part2(input: String) = solve(input, 14)

    val input = readInput("Day06")
    println(part1(input.first()))
    println(part2(input.first()))
}
