package src.main.kotlin

fun main() {
    val list= mutableListOf<String>()
    generatePermutation("","abc",list)
    println(list)
}

fun generatePermutation(processed:String,unProcessed:String,ans:MutableList<String>):MutableList<String>{
    if (unProcessed.isEmpty()){
        ans.add(processed)
        return ans
    }
    val ch=unProcessed[0]
    for (i in 0..processed.length){
        val first=processed.substring(0,i)
        val second=processed.substring(i,processed.length)
        generatePermutation(first+ch+second,unProcessed.substring(1),ans)
    }
    return ans
}