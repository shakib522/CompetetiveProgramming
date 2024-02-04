package codeforces

import java.util.*

fun main(){
    val scanner= Scanner(System.`in`)
    val t=scanner.nextInt()
    repeat(t){
        val n=scanner.nextInt()
        val string=scanner.next()
        println(splitting(string.removeRange(0,1),string.removeRange(1,2)))
    }
}

fun splitting(s1:String,s2:String):Int{
    if(s1.length<2){
        return 0
    }
    val ans:MutableSet<String> = mutableSetOf()
    splitting(s1.removeRange(0,1),s2.removeRange(1,2))
    ans.add(s1)
    ans.add(s2)
    return ans.size
}