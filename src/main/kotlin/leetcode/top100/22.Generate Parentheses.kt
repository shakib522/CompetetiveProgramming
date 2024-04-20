package src.main.kotlin.leetcode.top100

fun main() {
    println(generateParenthesis(2))
}

fun generateParenthesis(n: Int): List<String> {
    val ans= mutableListOf<String>()
    generate("",0,0,n,ans)
    return ans
}

fun generate(str:String,l:Int,r:Int,n:Int,ans:MutableList<String>):MutableList<String>{
    if (str.length==n*2){
        ans.add(str)
        return ans
    }

    if(l<n){
        generate("$str(",l+1,r,n,ans)
    }
    if(r<l){
        generate("$str)",l,r+1,n,ans)
    }
    return ans
}