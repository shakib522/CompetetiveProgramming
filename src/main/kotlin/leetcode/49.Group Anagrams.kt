package src.main.kotlin.leetcode


fun main() {
    println(groupAnagrams(arrayOf("a")))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {

    val map= HashMap<String,MutableList<String>>()
    for (i in strs.indices) {
        val word=strs[i].toCharArray()
        word.sort()
        val sortedWord=String(word)
        if (!map.containsKey(sortedWord)){
            map[sortedWord] = mutableListOf()
        }
        map.get(sortedWord)?.add(strs[i])
    }

    return map.values.toList()
}