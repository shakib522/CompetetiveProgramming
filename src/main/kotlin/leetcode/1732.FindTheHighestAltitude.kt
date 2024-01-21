package leetcode

import java.util.Scanner
import kotlin.math.max

fun main(){
    val scanner=Scanner(System.`in`)
    val n=scanner.nextInt()
    val array=IntArray(n)
    for (i in 0 ..<n){
        array[i]=scanner.nextInt()
    }
    println(largestAltitude(array))
}
fun largestAltitude(gain: IntArray): Int {
    for (i in 1..<gain.size){
        gain[i]=gain[i]+gain[i-1]
    }
    gain.sortDescending()
    val ans= max(0, gain[0])
    return ans
}