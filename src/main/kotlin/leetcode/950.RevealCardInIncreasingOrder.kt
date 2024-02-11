package leetcode

import java.util.*

fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val array=IntArray(n)
    for (i in 0 ..<n){
        array[i]=scanner.nextInt()
    }
    deckRevealedIncreasing(array).forEach {
        println(it)
    }
}

fun deckRevealedIncreasing(deck: IntArray): IntArray {
    val q= mutableListOf<Int>()
    val n=deck.size
    deck.sort()
    var half=(n/2)
    if(n%2==1){
        half++
    }
    println(half)
    for (i in 0..<half){
        q.add(deck[i])
        if (i+half==n){
            break
        }
        q.add(deck[i+half])
    }
    return q.toIntArray()
}