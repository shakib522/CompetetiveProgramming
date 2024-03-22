package src.main.kotlin.leetcode.q75

import java.util.*
import kotlin.math.max


fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val array=IntArray(n)
    for (i in 0 ..<n){
        array[i]=scanner.nextInt()
    }
    println(longestSubarray(array))
}
fun longestSubarray(nums: IntArray): Int {

    var first=0
    var last=0
    var isDelete=false
    var ans=0
    var zero=0
    var one=0

   while (last<nums.size){
       if (nums[last]==1){
           one++
           last++
           ans= max(ans,one)
       }else if(nums[last]==0){
           isDelete=true
           if (zero==0){
               zero++
               last++
           }else{
               ans= max(ans,one)
               if(nums[first]==0){
                   zero--
               }else{
                   one--
               }
               first++
           }
       }
   }
    if(!isDelete){
        return nums.size-1
    }
    return ans
}