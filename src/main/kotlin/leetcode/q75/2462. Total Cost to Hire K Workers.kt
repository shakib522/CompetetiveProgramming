package src.main.kotlin.leetcode.q75

import java.util.*

fun main() {
    println(totalCost(intArrayOf(31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58),11,2))
}

fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
    var candidates2 = candidates-1
    var numberOfWorker = k
    val pq1 = PriorityQueue<Int>()
    val pq2 = PriorityQueue<Int>()
    for (i in 0..<candidates) {
        pq1.offer(costs[i])
    }
    var sec =costs.size - candidates
    if (sec<candidates){
        sec=candidates
    }
    for (i in sec..<costs.size) {
        pq2.offer(costs[i])
    }
    var ans = 0L
    while (numberOfWorker > 0 ) {
        var p1:Int
        var p2 :Int
        if (pq1.isEmpty()){
            p1=Int.MAX_VALUE
        }else{
             p1 = pq1.peek()
        }
        if (pq2.isEmpty()){
            p2=Int.MAX_VALUE
        }else{
            p2=pq2.peek()
        }

        if (p1 <= p2) {
            ans += p1
            pq1.poll()
            if (candidates2 + 1 < sec) {
                candidates2++
//                println("candidates2: $candidates2")
                pq1.offer(costs[candidates2])
            }
        } else if (p2 < p1) {
            ans += p2
            pq2.poll()
            if(sec-1>candidates2){
                sec--
                pq2.offer(costs[sec])
            }
        }
//        println("p1: $p1 p2: $p2")
        numberOfWorker--
    }
    return ans
}