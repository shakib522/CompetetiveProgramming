package codeforces

import java.util.Scanner

fun main(){
    val scanner=Scanner(System.`in`)
    val t=scanner.nextInt()
    repeat(t){
        val n=scanner.nextInt()
        val array=LongArray(n)
        val ans= mutableListOf<Long>()
        var odd=0L
        for (i in 0..<n){
            array[i]=scanner.nextLong()
        }
        ans.add(array[0])
        var sum = ans[0]
        if (sum%2==1L){
            odd++
        }
        for (i in 1..<n){
            if (array[i]%2==1L){
                odd++
            }
            sum+=array[i]
            var f=sum-(odd/3L)
            if (odd%3==1L){
                f--
            }
            ans.add(f)
        }
        println(ans.joinToString(" "))
    }
}