package src.main.kotlin.leetcode.q75

import java.util.*

fun main() {
    val scan= Scanner(System.`in`)
    val n = scan.nextInt()
    val ara= IntArray(n)
    for (i in 0..<n){
        ara[i]=scan.nextInt()
    }
    val k=scan.nextInt()
    findKthLargest(ara,k)
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    val comparator = Comparator<Int>{p1,p2 ->
        p2-p1
    }
    val pq=PriorityQueue(comparator)
    nums.forEach {
        pq.offer(it)
    }
    for (i in 1..<k){
        pq.poll()
    }
    return pq.poll()
}