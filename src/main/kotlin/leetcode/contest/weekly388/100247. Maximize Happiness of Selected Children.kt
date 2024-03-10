package src.main.kotlin.leetcode.contest.weekly388

import kotlin.math.max

fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    happiness.sortDescending()
    var decrease=0
    var ans=0L
    for (i in 0 ..<k){
        ans+=max(0,happiness[i]-decrease)
        decrease++
    }
    return ans
}