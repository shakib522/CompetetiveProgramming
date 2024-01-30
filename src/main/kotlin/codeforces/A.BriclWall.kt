package codeforces

import java.util.Scanner
fun main(){
    val scanner=Scanner(System.`in`)
    val testcase=scanner.nextInt()
    repeat(testcase){
        val n=scanner.nextLong()
        val m = scanner.nextLong()
        val div=m/2
        println(div*n)

    }
}