package src.main.kotlin.leetcode

fun findContentChildren(g: IntArray, s: IntArray): Int {
    var maxCookies=0
    g.sort()
    s.sort()
    var i=0
    var j=0
    while (i<g.size && j<s.size){
        if (g[i]<=s[j]){
            maxCookies++
            i++
            j++
        }else{
            j++
        }
    }
    return maxCookies
}