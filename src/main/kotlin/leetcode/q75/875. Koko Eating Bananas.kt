package src.main.kotlin.leetcode.q75

import java.util.*

fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val numArray=IntArray(n)
    for (i in 0..<n){
        numArray[i]=scanner.nextInt()
    }
    val h=scanner.nextInt()
    println(minEatingSpeed(numArray,h))
}

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var end=piles.max()
    var start=1
    while (start<end){
        val mid=(start+end)/2
        var k=0
        for(element in piles){
            k+=(element /mid) + if(element%mid>0) 1 else 0
        }
        if(k>h){
            start=mid+1
        }else{
            end=mid
        }
    }
    return start
}

open class Car{
    fun printCar(name:String){

    }
}

class BMW:Car(){
    fun check(){
        printCar("BMW")
    }
}