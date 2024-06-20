package src.main.kotlin.leetcode.q75

import java.util.*

fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val inds=nums1.indices.sortedWith(
        compareByDescending<Int> { nums2[it] }
            .thenByDescending { nums1[it] }
    )
    var score=0L
    var sum = 0L
    val pq=PriorityQueue<Int> (compareBy{ nums1[it]})
    inds.forEach {
        sum+=nums1[it].toLong()
        pq.add(it)
        if (pq.size > k){
            sum-= nums1[pq.poll()].toLong()
        }
        if (pq.size==k){
            score = maxOf(score, sum*nums2[it].toLong())
        }
    }
    return score
}