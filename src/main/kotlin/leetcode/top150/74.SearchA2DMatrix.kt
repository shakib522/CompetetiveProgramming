package src.main.kotlin.leetcode.top150


fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    for (i in matrix){
        if (bSearchOn2D(i,target)){
            return true
        }
    }
    return false
}

fun bSearchOn2D(ara:IntArray,target: Int):Boolean{
    var start=0
    var end=ara.size-1
    while (start<=end){
        val mid=start+(end-start)/2
        if (ara[mid]==target){
            return true
        }else if(ara[mid]>target){
            end=mid-1
        }else{
            start=mid+1
        }
    }
    return false
}