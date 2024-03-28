package src.main.kotlin.leetcode.top100

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val mat = Array(n) { IntArray(n) }
    for (i in 0..<n) {
        for (j in 0..<n) {
            mat[i][j] = scanner.nextInt()
        }
    }
    rotate(mat)

}

fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix[0].size
    for (i in 0..<n) {
        for (j in i..<n) {
            if(i!=j){
                matrix[j][i] =  matrix[j][i] + matrix[i][j]
                matrix[i][j] =  matrix[j][i] - matrix[i][j]
                matrix[j][i] =  matrix[j][i] - matrix[i][j]
            }

        }
    }
    for (i in 0..<n) {
        var left = 0
        var right = n - 1
        while (left < right) {
             matrix[i][left]=matrix[i][left] xor matrix[i][right]
             matrix[i][right]=matrix[i][left] xor matrix[i][right]
             matrix[i][left]=matrix[i][left] xor matrix[i][right]
            left++
            right--
        }
    }
}