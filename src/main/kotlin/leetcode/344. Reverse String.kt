package src.main.kotlin.leetcode

fun main(){
    reverseString(readln().toCharArray())
}

fun reverseString(s: CharArray): Unit {
    println(reverse(0,s.size-1,s))
}

fun reverse(first:Int,last:Int,s:CharArray):CharArray{
    if (first>last){
        return s
    }
    val temp=s[first]
    s[first]=s[last]
    s[last]=temp
    return reverse(first+1,last-1,s)
}