package codeforces

import java.util.*
import kotlin.math.abs

fun main() {
    val scanner = Scanner(System.`in`)
    val testcase = scanner.nextInt()
    repeat(testcase) {
        var x: Int
        var y: Int
        val sets= ArrayList<Int>()
        for (i in 0..<4) {
            x=scanner.nextInt()
            y=scanner.nextInt()
            sets.add(y)
        }
        sets.sort()
        val ans= abs(sets[0]-sets[sets.size-1])
        println(ans*ans)
    }
}