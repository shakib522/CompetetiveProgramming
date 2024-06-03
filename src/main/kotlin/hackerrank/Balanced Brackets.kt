package src.main.kotlin.hackerrank

import java.util.*

/*
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun isBalanced(s: String): String {
    val stack=Stack<Char>()
    for (i in s.indices){
        if(s[i]=='('||s[i]=='{' || s[i]=='[' || stack.isEmpty()){
            stack.push(s[i])
        }else if (stack.peek()=='('&&s[i]==')' || stack.peek()=='{'&&s[i]=='}' || stack.peek()=='['&&s[i]==']'){
            stack.pop()
        }else{
            stack.push(s[i])
        }
    }
    return if(stack.isEmpty()){
        "YES"
    } else{
        "NO"
    }
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val s = readLine()!!

        val result = isBalanced(s)

        println(result)
    }
}
