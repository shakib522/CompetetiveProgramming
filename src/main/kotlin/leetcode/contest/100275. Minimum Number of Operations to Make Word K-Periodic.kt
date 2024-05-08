package src.main.kotlin.leetcode.contest

fun minAnagramLength(s: String): Int {
    val ara=Array(27){0}
    for (i in s.indices){
        ara[s[i]-'a']++
    }
    var ans=0
    for (i in ara.indices){
        if (ara[i]>0){
            ans++
        }
    }
    return ans
}