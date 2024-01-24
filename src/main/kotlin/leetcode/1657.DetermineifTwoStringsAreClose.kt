package leetcode

import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)
    val str1 = scanner.nextLine()
    val str2 = scanner.nextLine()
    println(closeStrings(str1, str2))
}

fun closeStrings(word1: String, word2: String): Boolean {
    if(word1.length!=word2.length){
        return false
    }
    val map1= hashMapOf<Char,Int>()
    val map2= hashMapOf<Char,Int>()
    if(word1.toCharArray().toSet()!=word2.toCharArray().toSet()){
        return false
    }
    word1.forEach {
        map1[it] = map1.getOrDefault(it,0)+1
    }
    word2.forEach {
        map2[it]=map2.getOrDefault(it,0)+1
    }
    val list1=map1.values.toList().sorted()
    val list2=map2.values.toList().sorted()
    return list1==list2

}