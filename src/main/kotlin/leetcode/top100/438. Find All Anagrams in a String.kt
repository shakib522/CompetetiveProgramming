package src.main.kotlin.leetcode.top100


fun main() {
    println(findAnagrams(readln(), readln()))
}

fun findAnagrams(s: String, p: String): List<Int> {
    var w1 = 0
    val ans = mutableListOf<Int>()
    var w2 = p.length
    while (w2 <= s.length) {
        if (isContain(s.substring(w1, w2), p)) {
            ans.add(w1)
        }
        w1++
        w2++
    }
    return ans
}

fun isContain(s1: String, s2: String): Boolean {
    val ara = IntArray(27) { 0 }
    val ara2 = IntArray(27) { 0 }
    for (i in s2.indices) {
        ara2[s2[i].code - 97]++
    }
    for (i in s1.indices) {
        ara[s1[i].code - 97]++
    }
    return ara.contentEquals(ara2)
}