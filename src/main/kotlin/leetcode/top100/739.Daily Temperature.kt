package src.main.kotlin.leetcode.top100

import java.util.Stack

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack=Stack<Int>()
    val ans=IntArray(temperatures.size)
    stack.push(0)
    for (i in 1..<temperatures.size){
        val todayTemp=temperatures[i]
        while (stack.isNotEmpty()&&temperatures[stack.peek()]<todayTemp){
            val day=stack.pop()
            ans[day]=i-day
        }
        stack.push(i)
    }
    return ans
}