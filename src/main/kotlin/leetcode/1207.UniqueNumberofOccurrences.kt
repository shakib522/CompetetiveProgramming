package leetcode

import java.util.*


fun main()
{
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val array=IntArray(n)
    for (i in 0 ..<n){
        array[i]=scanner.nextInt()
    }
    println(uniqueOccurrences(array))
}
fun uniqueOccurrences(arr: IntArray): Boolean {
    val set= mutableSetOf<Int>()
    val map= hashMapOf<Int,Int>()
    arr.forEach {
        map.put(it,map.getOrDefault(it,0)+1)
    }
    set.addAll(map.values)
    return map.values.size==set.size
}
