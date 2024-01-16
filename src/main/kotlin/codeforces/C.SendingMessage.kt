package codeforces

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val testcase = scanner.nextInt()
    repeat(testcase) {
        val n=scanner.nextInt()
        var f=scanner.nextLong()
        val a=scanner.nextLong()
        val b=scanner.nextLong()
        val m=LongArray(n)
        for (i in 0..<n){
            m[i]=scanner.nextLong()
        }
        var cnt=0L
        for (i in m){
            if(((i-cnt)*a)>b){
                f-=b
            }else if(((i-cnt)*a)<=b){
                f-=((i-cnt)*a)
            }
            cnt=i
        }
        if(f<=0){
            println("NO")
        }else{
            println("YES")
        }
    }
}