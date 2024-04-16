package src.main.kotlin.leetcode.top100

fun main(){
    println(letterCombinations("23"))
}
fun letterCombinations(digits: String): List<String> {
    if(digits.isEmpty()){
        return emptyList()
    }
    return pad("",digits, mutableListOf())
}
fun pad(p:String,up:String,ans:MutableList<String>):MutableList<String>{
    if (up.isEmpty()){
        ans.add(p)
        return ans
    }
    val digit=up[0].digitToInt()
    var start=(digit-2)*3
    var end=((digit-1)*3)
    if(digit==8){
        start++
        end++
    }
    if(digit==7){
        end++
    }
    if( digit == 9){
        start++
        end+=2
    }
    for (i in start..<end){
        val ch= ('a'+i)
        pad(p+ch,up.substring(1),ans)
    }
    return ans
}


//
//fun letterCombinations(digits: String): List<String> {
//
//}