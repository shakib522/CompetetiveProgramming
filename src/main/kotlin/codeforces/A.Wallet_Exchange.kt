package codeforces

import java.util.Scanner
val scanner=Scanner(System.`in`)
fun main() {

    val testcase=scanner.nextInt()
    repeat(testcase){
        solveWalletProblem()
    }
}
fun solveWalletProblem(){
    val a= scanner.nextLong()
    val b= scanner.nextLong()
    val c=a+b
    if(c%2==0L){
        println("Bob")
    }else{
        println("Alice")
    }
}