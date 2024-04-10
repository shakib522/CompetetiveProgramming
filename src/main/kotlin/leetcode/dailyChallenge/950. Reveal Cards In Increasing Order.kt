package src.main.kotlin.leetcode.dailyChallenge

fun main(){

}
fun deckRevealedIncreasing(deck: IntArray): IntArray {
    deck.sort()
    val result=IntArray(deck.size)
    val deque=ArrayDeque<Int>()
    for (i in 0..<deck.size){
        deque.addLast(i)
    }
    for (element in deck){
        val idx=deque.removeFirst()
        result[idx]=element
        if(deque.isNotEmpty()){
            deque.addLast(deque.removeFirst())
        }
    }
    return result

}