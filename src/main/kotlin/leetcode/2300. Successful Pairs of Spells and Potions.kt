package src.main.kotlin.leetcode

import java.util.*

fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val m=scanner.nextInt()
    val numArray=IntArray(n)
    val numArray2=IntArray(m)
    for (i in 0..<n){
        numArray[i]=scanner.nextInt()
    }
    for (i in 0..<m){
        numArray2[i]=scanner.nextInt()
    }
    val success=scanner.nextLong()
    successfulPairs(numArray,numArray2,success).forEach {
        println(it)
    }
}

fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    val pot= mergeSort(potions)
    val ans= mutableListOf<Int>()
    for (i in spells.indices){
        val indx=bSearch(pot,0,pot.size-1,-1,spells[i],success)
        if(indx==-1){
            ans.add(0)
        }else{
            ans.add(pot.size-indx)
        }
    }
    return ans.toIntArray()
}

fun bSearch(arr:IntArray,s:Int,e:Int,index:Int,iSpell:Int,success: Long):Int{
    if (s>e){
        return index
    }
    val mid=s+(e-s)/2
    if((arr[mid]*iSpell.toLong())>=success){
        return bSearch(arr,s,mid-1,mid,iSpell,success)
    }
    if ((arr[mid]*iSpell.toLong()) < success){
        return bSearch(arr,mid+1,e,index,iSpell,success)
    }
    return index
}

fun mergeSort(array:IntArray):IntArray{
    if(array.size==1){
        return array
    }
    val mid=array.size/2
    val left= mergeSort(array.copyOfRange(0,mid))
    val right= mergeSort(array.copyOfRange(mid,array.size))
    return merge(left,right)
}

fun merge(first:IntArray,second:IntArray):IntArray{
    val mergeArray=IntArray(first.size+second.size)
    var i=0
    var j=0
    var k=0
    while (i<first.size&&j<second.size){
        if (first[i]<second[j]){
            mergeArray[k]=first[i]
            i++
        }else{
            mergeArray[k]=second[j]
            j++
        }
        k++
    }
    while (i<first.size){
        mergeArray[k]=first[i]
        i++
        k++
    }
    while (j<second.size){
        mergeArray[k]=second[j]
        j++
        k++
    }
    return mergeArray
}