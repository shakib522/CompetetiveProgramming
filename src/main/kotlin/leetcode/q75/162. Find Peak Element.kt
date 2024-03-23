package src.main.kotlin.leetcode.q75

import java.util.*


fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val numArray=IntArray(n)
    for (i in 0..<n){
        numArray[i]=scanner.nextInt()
    }
    findPeakElement(numArray)
}
fun findPeakElement(nums: IntArray): Int {
    val ans= binaryIterative(nums,0,nums.size-1)
    println(ans)
    return ans
}
fun binaryIterative(array: IntArray,s:Int,e:Int):Int{

    var end=e
    var start=s
    while (start<=end){
        val mid=start+(end-start)/2
        var midleft=Long.MIN_VALUE
        var midRight=Long.MIN_VALUE
        if (mid-1>=0){
            midleft=array[mid-1].toLong()
        }
        if (mid+1<array.size){
            midRight=array[mid+1].toLong()
        }
        if(array[mid]>midleft&&array[mid]>midRight){
            return mid
        }
        if (midleft>array[mid]){
            end=mid-1
        }else if (array[mid]<midRight){
            start=mid+1
        }
    }
    return -1
}
fun binaryS(array: IntArray,s:Int,e:Int):Int{
    if (s>e){
        return -1
    }
    val mid=s+(e-s)/2
    var midleft=Long.MIN_VALUE
    var midRight=Long.MIN_VALUE
    if (mid-1>=0){
        midleft=array[mid-1].toLong()
    }
    if (mid+1<array.size){
        midRight=array[mid+1].toLong()
    }
    if(array[mid]>midleft&&array[mid]>midRight){
        return mid
    }
    if (array[mid]<midleft){
        return binaryS(array,s,mid-1)
    }
    return binaryS(array,mid+1,e)
}