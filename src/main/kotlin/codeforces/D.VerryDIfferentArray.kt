package codeforces

import java.util.*
import kotlin.math.abs

fun main() {
    val scanner = Scanner(System.`in`)
    val testcase = scanner.nextInt()
    repeat(testcase) {
        val n=scanner.nextInt()
        val m=scanner.nextInt()
        val firstArray= mutableListOf<Int>()
        val secondArray= mutableListOf<Int>()
        for (i in 0..<n){
            firstArray.add(scanner.nextInt())
        }
        for (i in 0..<m){
            secondArray.add(scanner.nextInt())
        }
        var ans=0L
        firstArray.sort()
        secondArray.sortDescending()
        for (i in 0..<n){
            val first=abs(firstArray[i]-secondArray[0])
            val second=abs(firstArray[i]-secondArray[secondArray.size-1])
            if(first<second){
                ans+=second
                secondArray.removeAt(secondArray.size-1)
            }else{
                ans+=first
                secondArray.removeAt(0)
            }
        }
        println(ans)
    }
}