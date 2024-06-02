package src.main.kotlin.leetcode.top150

import kotlin.math.max

fun main() {

}

fun maxProfit(prices: IntArray): Int {
    var ans=0
    var buy=0
    for(i in prices.indices){
        ans= max(ans,prices[i]-prices[buy])
        if (prices[buy]>prices[i]){
            buy=i
        }
    }
    return ans
}