package src.main.kotlin.leetcode.top100

import kotlin.math.max

fun main(){
    println(lengthOfLongestSubstring(readln()))
}

fun lengthOfLongestSubstring(s: String): Int {
    var end=0
    if (s.isEmpty()){
        return end
    }
    var ans=Int.MIN_VALUE
    val strBuilder:StringBuilder=StringBuilder()
    while (end<s.length){
        if (strBuilder.contains(s[end])){
            ans=max(ans,strBuilder.length)
            strBuilder.deleteAt(0)
        }else{
            strBuilder.append(s[end])
            end++
        }
    }
    ans=max(ans,strBuilder.length)
    return ans
}