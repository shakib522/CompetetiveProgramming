package codeforces

import java.util.Scanner
import kotlin.math.max
import kotlin.math.min

val scan=Scanner(System.`in`)
fun main() {

    val testcase=scan.nextInt()
    repeat(testcase){
        solveSatisfyingConstraints()
    }
}
fun solveSatisfyingConstraints(){
    val n= scan.nextInt()
    var a:Int
    var x:Int
    var greater=0
    var less=Int.MAX_VALUE
    val notEqual=ArrayList<Int>()
    repeat(n){
        a= scan.nextInt()
        x= scan.nextInt()
        when (a) {
            1 -> {
                greater= max(greater,x)
            }
            2 -> {
                less= min(less,x)
            }
            else -> {
                notEqual.add(x)
            }
        }
    }
    var count=notEqual.size
    for (i in notEqual.indices){
        if(notEqual[i] <=greater||notEqual[i]>=less){
            count--
        }
        if(notEqual[i]==greater){
            greater++
        }
        if(notEqual[i]==less){
            less--
        }
    }
    var ans=less-greater
    ans-=count
    if(ans<0){
        ans=0
    }else{
        ans+=1
    }
    println(ans)
}