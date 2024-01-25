package leetcode

import java.util.*
import kotlin.math.abs

fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val array=IntArray(n)
    for (i in 0 ..<n){
        array[i]=scanner.nextInt()
    }
    asteroidCollision(array).forEach {
        print("$it ")
    }
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack=Stack<Int>()
    var i=0
    while (i<asteroids.size){
        if (asteroids[i]<0){
            if(stack.isEmpty()||stack.peek()<0){
                stack.push(asteroids[i])
                i++
            }else if(stack.peek()< abs(asteroids[i])){
                stack.pop()
            }else if(stack.peek()== abs(asteroids[i])){
                stack.pop()
                i++
            }
            else{
                i++
            }
        }else{
            stack.push(asteroids[i])
            i++
        }
    }
    return stack.toIntArray()
}