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
        var i=0
        var j=m-1
        var k=n-1
        var cnt=0
        while (i<n){
            if(cnt==n){
                break
            }
            val first=abs(firstArray[i]-secondArray[i])
            val second=abs(firstArray[k]-secondArray[j])
            if(first<=second){
                ans+=second
                j--
                k--
                cnt++
            }else{
                ans+=first
                i++
                cnt++
            }
        }
        println(ans)
    }
}