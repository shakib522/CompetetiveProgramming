package codeforces

import java.util.*
import kotlin.math.abs

fun main() {
    val scanner = Scanner(System.`in`)
    val testcase = scanner.nextInt()
    repeat(testcase) {
        var plus = 0
        var minus = 0
        val n = scanner.nextInt()
        scanner.nextLine()
        val string = scanner.nextLine()
        string.forEach {
            if (it == '-') {
                minus++
            } else {
                plus++
            }
        }
        val ans = abs(plus - minus)
        println(ans)
    }
}