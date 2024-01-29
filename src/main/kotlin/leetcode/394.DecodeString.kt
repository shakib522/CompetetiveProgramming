package leetcode

import java.util.Stack


fun main() {
    println(decodeString(readln()))
}


fun decodeString(s: String): String {
    val stk=Stack<StringBuilder>()
    var num=0
    for (i in s){
        println(i.code)
    }
    val output=StringBuilder()
    for (char in s){
        if(char.isDigit()){
            num= (num*10+(char-'0'))
            continue
        }
        if(char=='['){
            stk.push(StringBuilder(num.toString()))
            stk.push(StringBuilder(output))
            num=0
            output.clear()
            continue
        }
        if(char==']'){
            val prevString=stk.pop()
            val previousNumber=stk.pop().toString().toInt()
            for (i in 0..<previousNumber){
                prevString.append(output)
            }
            output.clear().append(prevString)
            continue
        }
        output.append(char)
    }
    return output.toString()
}
