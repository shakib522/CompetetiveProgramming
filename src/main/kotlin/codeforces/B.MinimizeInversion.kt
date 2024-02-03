package codeforces

import java.util.*
fun main() {
    val scanner = Scanner(System.`in`)
    val testcase = scanner.nextInt()
    repeat(testcase) {
        val n = scanner.nextInt()
        val array1 = IntArray(n)
        val array2 = IntArray(n)
        val map = mutableMapOf<Int, Int>()
        for (i in 0..<n) {
            array1[i] = scanner.nextInt()
        }
        for (i in 0..<n) {
            array2[i] = scanner.nextInt()
            map[array1[i]] = array2[i]
        }
        val sortedMap = map.toSortedMap()
        for (i in sortedMap.keys){
            print("$i ")
        }
        println()
        for (i in sortedMap.values){
            print("$i ")
        }
        println()
    }
}