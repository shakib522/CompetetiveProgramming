package src.main.kotlin.leetcode.top150

fun strStr(haystack: String, needle: String): Int {
    var f=0
    var l=needle.length
    while(l<=haystack.length){
        if(haystack.substring(f,l)==needle){
            return f
        }else{
            f++
            l++
        }
    }
    return -1
}