package leetcode

fun main(){
    println(firstUniqChar(readln()))
}

fun firstUniqChar(s: String): Int {
    val array=IntArray(200){0}
    for (i in s.indices){
        array[s[i].code]++
    }
    for (i in s.indices){
        if (array[s[i].code]==1){
            return i
        }
    }
    return  -1
}