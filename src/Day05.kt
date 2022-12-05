fun main() {

    fun solve(input: List<String>, pred : (MutableList<ArrayDeque<Char>>, Int, Int, Int) -> Unit) : String {
        val numLine = input.indexOfFirst { it.contains('1') }
        val stacksCount = input[numLine].split(' ').last { it.isNotEmpty() }.toInt()

        // assuming the stacks count is single-digit
        val stacks = mutableListOf<ArrayDeque<Char>>()
        for(i in 0 until stacksCount) {
            stacks.add(ArrayDeque())
            for (j in numLine - 1 downTo 0) {
                val c = input[j][1 + i * 4]
                if (c == ' ') break
                stacks[i].addLast(c)
            }
        }

        input.subList(numLine + 2, input.size).forEach {
            val command = it.split(' ')
            val amount = command[1].toInt()
            val from = command[3].toInt() - 1
            val to = command[5].toInt() - 1
            pred(stacks, amount, from, to)
        }
        return stacks.map { it.last() }.joinToString(separator = "")
    }

    fun part1(input: List<String>) = solve(input) {stacks, amount, from,to ->
        repeat(amount) {
            val c = stacks[from].removeLast()
            stacks[to].addLast(c)
        }
    }

    fun part2(input: List<String>) = solve(input) {stacks, amount, from,to ->
        stacks[to].addAll(stacks[from].subList(stacks[from].size - amount,stacks[from].size))
        repeat(amount) {stacks[from].removeLast()}
    }

    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
