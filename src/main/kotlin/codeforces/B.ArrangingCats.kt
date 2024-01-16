package codeforces

import java.util.*
import kotlin.math.max

fun main() {
    val scanner = Scanner(System.`in`)
    val testcase = scanner.nextInt()
    repeat(testcase) {
       val n=scanner.nextInt()
        scanner.nextLine()
        val string1=scanner.nextLine()
        val string2=scanner.nextLine()
        var zero=0
        var one=0
        for (i in 0..<n){
            if(string1[i]!=string2[i]){
                if(string2[i]=='0'){
                    zero++
                }else{
                    one++
                }
            }
        }
        println(max(zero,one))
    }
}