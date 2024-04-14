package src.main.kotlin.leetcode

fun main(){
    findTheWinner(5,2).also(::println)
}

fun findTheWinner(n: Int, k: Int): Int {
    val list= mutableListOf<Int>()
    for (i in 1..n){
        list.add(i)
    }
    var start=0
    while (list.size>1){
        val siz=list.size
//        println(list[(start+(k-1))%siz])
//        println("index: ${(start+(k-1))%siz}")
        list.removeAt((start+(k-1))%siz)
        start=(start+(k-1))%siz
    }
    return list[0]
}