package src.main.kotlin.leetcode

import kotlin.math.ln

fun main(){
    println( numberOfSteps(14))
}

fun numberOfSteps(num: Int): Int {
    if (num==0){
        return 0
    }
    if (num%2==1){
        return 1+numberOfSteps(num-1)
    }
    return 1+numberOfSteps(num/2)
}