package src.main.kotlin.leetcode.top150

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var k=0
    for(i in m..<m+n){
        nums1[i]=nums2[k]
        k++
    }
    nums1.sort()
}