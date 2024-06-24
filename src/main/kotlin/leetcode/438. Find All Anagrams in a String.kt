package src.main.kotlin.leetcode

fun findAnagrams(s: String, p: String): List<Int> {
    val ans= mutableListOf<Int>()
    for (i in 0..s.length-p.length){
        var subString = s.substring(i,p.length).toCharArray()
        val sortedP=p.toCharArray()
        sortedP.sort()
        subString.sort()
        if (sortedP.contentEquals(subString)){
            ans.add(i)
        }
    }
    return ans
}