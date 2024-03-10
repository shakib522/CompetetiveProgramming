package src.main.kotlin.leetcode.contest.weekly388

import java.util.Scanner

fun main(){
    val scanner=Scanner(System.`in`)
    val n= readln().toInt()
    val m= readln().toInt()
    val apple=IntArray(n)
    val capacity=IntArray(m)
    for (i in 0..<n){
        apple[i]= scanner.nextInt()
    }
    for (i in 0..<m){
        capacity[i]= scanner.nextInt()
    }
    println(minimumBoxes(apple,capacity))

}

fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
    capacity.sortDescending()
    var appleSum=0
    var capacitySum=0
    var ans=0
    apple.forEach {
        appleSum+=it
    }
    for (element in capacity){
        if(capacitySum>=appleSum){
            break
        }
        capacitySum+= element
        ans++
    }
    return ans
}