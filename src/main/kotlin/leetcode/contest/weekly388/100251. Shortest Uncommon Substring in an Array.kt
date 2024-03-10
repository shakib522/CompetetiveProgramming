package src.main.kotlin.leetcode.contest.weekly388

import java.util.Scanner


fun shortestSubstrings(arr: Array<String>): Array<String> {

    //unsolved

    val ans=Array(arr.size){" "}
    for (i in arr.indices){
        val subarray= mutableListOf<String>()
        val charArr=arr[i].toCharArray()
        for (j in charArr.indices){
            var switch=true
            var check=""
             check+=charArr[j]
            for (k in arr.indices){
                if (k==i){
                    continue
                }
                if (arr[k].contains(check)){
                    switch=false
                    break
                }
            }
            if (switch){
                subarray.add(check)
            }
        }
        if(subarray.isNotEmpty()){
            subarray.sort()
            ans[i]=subarray[0]
        }
    }
    return ans
}

fun main(){
    val scanner = Scanner(System.`in`)
    val s= scanner.nextInt()
    scanner.next()
    val array=Array(s){" "}
    for (i in 0..<s){
        array[i]= scanner.nextLine()
    }
    shortestSubstrings(array).forEach {
        println(it)
    }
}