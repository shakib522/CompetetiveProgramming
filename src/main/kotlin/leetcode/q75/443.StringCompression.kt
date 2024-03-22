package src.main.kotlin.leetcode.q75

import java.util.*
fun compress(chars: CharArray): Int {
    if(chars.size==1){
        return 1
    }
    var length=0
    var cnt=1
    var idx=0
    var j=0
    var bool=true
    if(chars.size>=2&&chars[chars.size-1]!=chars[chars.size-2]){
        bool=false
    }
    for(i in 0..<chars.size-1){
        j++
        if(chars[i]==chars[i+1]){
            cnt++
        }else{
            val dCount=digitCount(cnt)
            length+=dCount
            chars[idx]=chars[i]
            idx++
            if(cnt>1){
                length++
                for (digit in cnt.toString().toCharArray()){
                    chars[idx]=digit
                    idx++
                }
            }
            cnt=1
        }
    }
    if(!bool){
        length++
        chars[idx]=chars[j]
        idx++
    }
    if(cnt!=1){
        val dCount=digitCount(cnt)
        length+=dCount
        chars[idx]=chars[j]
        idx++
        if(cnt>1){
            length++
            for (digit in cnt.toString().toCharArray()){
                chars[idx]=digit
                idx++
            }
        }
    }

    println(chars)
    return length
}
fun main() {
    val scanner=Scanner(System.`in`)
    val charArray: CharArray
    val string=scanner.nextLine()
    charArray=string.toCharArray()
    println(compress(charArray))
}
fun digitCount(num:Int):Int{
    var cnt=0
    var n=num
    while (n!=0){
        n/=10
        cnt++
    }
    return cnt
}