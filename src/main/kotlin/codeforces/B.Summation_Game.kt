package codeforces

import java.util.*
import kotlin.math.max
import kotlin.math.min

val scan2 = Scanner(System.`in`)
fun main() {

    val testcase = scan2.nextInt()
    repeat(testcase) {
        solveSummationGame()
    }
}

fun solveSummationGame(){
    val n = scan2.nextInt()
    val k = scan2.nextInt()
    val x = scan2.nextInt()
    val list = ArrayList<Int>(n)
    val newList = ArrayList<Int>(n + 1)
    for (i in 0..<n) {
        list.add(scan2.nextInt())
    }
    list.sortDescending()
    newList.add(0)
    list.forEach {
        newList.add(it)
    }
    for (i in 1..n) {
        newList[i] = newList[i] + newList[i - 1]
    }
    var ans = Int.MIN_VALUE
    for (i in 0..k) {

        val f = (newList[n] - newList[i]) - ((newList[min( n,i + x)] - newList[i]) * 2)
        ans = max(ans, f)
    }
    println(ans)
    return
}