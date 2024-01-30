package codeforces

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val testcase = scanner.nextInt()
    repeat(testcase) {
        val n = scanner.nextInt()
        val array1 = IntArray(n)
        val array2 = IntArray(n)
        val map = HashMap<Int, Int>()
        for (i in 0..<n) {
            array1[i] = scanner.nextInt()
        }
        for (i in 0..<n) {
            array2[i] = scanner.nextInt()
            map[array1[i]] = array2[i]
        }
        val sortedMap = map.toSortedMap()
        sortedMap.forEach{
            print("${it.key} ")
        }
        println()
        sortedMap.forEach{
            print("${it.value} ")
        }
        println()
    }
}
