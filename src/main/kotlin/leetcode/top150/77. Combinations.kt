package src.main.kotlin.leetcode.top150


fun main(){
    println(combine(3,1))
}

fun combine(n: Int, k: Int): List<List<Int>> {
    val list= mutableListOf<Int>()
    for (i in 1..n){
        list.add(i)
    }
    val ans= mutableListOf<MutableList<Int>>()
    return solve(k,k, mutableListOf(),list, ans)
}

fun solve(element:Int,k:Int,processed:MutableList<Int>,unprocessed:MutableList<Int>,ans:MutableList<MutableList<Int>>):MutableList<MutableList<Int>>{
    if(processed.size==element){
        ans.add(processed)
        return ans
    }
    for (i in 0 .. unprocessed.size-k){
        if(i>=unprocessed.size){
            break
        }
        solve(element,k-1,(processed+unprocessed[i]).toMutableList(), getSubList(unprocessed,i+1,unprocessed.size),ans)
    }
    return ans
}
fun getSubList(array:MutableList<Int>,start:Int,end:Int):MutableList<Int>{
    val ans= mutableListOf<Int>()
    for (i in start..<end){
        ans.add(array[i])
    }
    return ans
}