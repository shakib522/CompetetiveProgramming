package src.main.kotlin.leetcode.q75

import java.util.PriorityQueue

class SmallestInfiniteSet() {
    private val pq = PriorityQueue<Int>()
    init{
        for(i in 1..1000){
            pq.offer(i)
        }
    }

    fun popSmallest(): Int {
        val pop= pq.poll()
        if (pop!=null){
            return pop
        }
        return 0
    }

    fun addBack(num: Int) {
        if (!pq.contains(num)) {
            pq.offer(num)
        }
    }
}