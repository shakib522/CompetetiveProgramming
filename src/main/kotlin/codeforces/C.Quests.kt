package codeforces

import java.util.Scanner
import kotlin.math.max

fun main() {
    val scanner = Scanner(System.`in`)
    val testcase = scanner.nextInt()
    repeat(testcase) {
        val n = scanner.nextInt()
        val k = scanner.nextInt()
        val a = LongArray(n)
        val b = LongArray(n)
        for (i in 0..<n){
            a[i]=scanner.nextLong()
        }
        for (i in 0..<n){
            b[i]=scanner.nextLong()
        }
        var sum=0L
        var best=0L
        var maxB=0L
        for (i in 0..<n) {
            sum+=a[i]
            maxB= max(maxB,b[i])
            if (k>=i+1){
                best= max(best,sum+maxB*(k-i-1))
            }
        }
        println(best)
    }
}