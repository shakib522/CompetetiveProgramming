package leetcode

import java.util.ArrayDeque
fun predictPartyVictory(senate: String): String {
    val n=senate.length
    val r= ArrayDeque<Int>()
    val d= ArrayDeque<Int>()
    for (i in senate.indices){
        if (senate[i]=='R'){
            r.addLast(i)
        }else{
            d.addLast(i)
        }
    }
    while (r.isNotEmpty()&&d.isNotEmpty()){
        val ri=r.poll()
        val di=d.poll()
        if (ri<di){
            r.addLast(n+ri)
        }else{
            d.addLast(n+di)
        }
    }
    return if (d.isEmpty()){
        "Radiant"
    }else{
        "Dire"
    }
}

fun main(){
    println(predictPartyVictory(readln()))
}