package src.main.kotlin.leetcode.q75

import java.util.Stack

fun main(){
    println(src.main.kotlin.leetcode.q75.isValid(readln()))
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (char in s) {
        if (char=='('||char=='['||char=='{'){
            stack.push(char)
        }else{
            if(stack.empty() || char==')' && stack.peek()!='('|| char=='}' && stack.peek()!='{'|| char==']' && stack.peek()!='['){
                return false
            }else{
                stack.pop()
            }
        }
    }
    return stack.empty()
}