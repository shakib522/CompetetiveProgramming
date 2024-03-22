package src.main.kotlin.leetcode

import kotlin.math.min


fun main(){
    val s=MinStack()
    s.push(2)
    s.push(0)
    s.push(3)
    s.push(0)
    println(s.getMin())
    s.pop()
    println(s.getMin())
    s.pop()
    println(s.getMin())
    s.pop()
    println(s.getMin())
}

class MinStack {
    private var array = IntArray(3000000)
    private var top=0
    private val list= mutableListOf<Int>()
    fun push(`val`: Int) {
        list.add(min(list.lastOrNull() ?: `val`,`val`))
        array[top]=`val`
        top++
    }

    fun pop() {
        top--
        list.removeLast()
    }

    fun top(): Int {
        return array[top-1]
    }

    fun getMin(): Int {
        return list.last()
    }
}