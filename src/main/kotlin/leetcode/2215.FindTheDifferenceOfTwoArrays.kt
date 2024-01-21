package leetcode

import java.util.*

fun main(){
    val scanner=Scanner(System.`in`)
    val n=scanner.nextInt()
    val m=scanner.nextInt()
    val nums1=IntArray(n)
    val nums2=IntArray(m)
    for (i in 0..<n){
        nums1[i]= scanner.nextInt()
    }
    for (i in 0..<m){
        nums2[i]= scanner.nextInt()
    }
    println(findDifference(nums1,nums2))
}

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val setA= mutableSetOf<Int>()
    val setB= mutableSetOf<Int>()
    setA.addAll(nums1.toList())
    setB.addAll(nums2.toList())
    val list= mutableListOf<MutableList<Int>>()
    list.add(mutableListOf())
    list.add(mutableListOf())
    setA.forEach{
        if (!setB.contains(it)){
            list[0].add(it)
        }
    }
    setB.forEach{
        if (!setA.contains(it)){
            list[1].add(it)
        }
    }
    return list
}