package src.main.kotlin.leetcode.q75

class Stak(private val stackSize: Int, private var top: Int) {
    val data = CharArray(stackSize)

    fun push(stack: Stak, item: Char) {
        if (stack.top < stack.stackSize) {
            stack.data[stack.top] = item
            stack.top++
        } else {
            println("Stack is full")
        }
    }

    fun pop(stack: Stak): Char {
        if (stack.top == 0) {
            println("Stack is empty")
            return ' '
        } else {
            stack.top--
            return stack.data[stack.top]
        }
    }

    fun topElement(stack: Stak): Char {
        return stack.data[stack.top - 1]
    }

    fun isEmpty(stack: Stak): Boolean {
        return stack.top == 0
    }

    fun siZe(stack: Stak): Int {
        return stack.top
    }
}
fun main() {
    println(removeStars(readln()))
}

fun removeStars(s: String): String {
    val stack = Stak(s.length, 0)
    for (i in s.indices) {
        if (s[i] != '*') {
            stack.push(stack, s[i])
        } else if (!stack.isEmpty(stack)) {
            stack.pop(stack)
        }
    }
    val ans = StringBuilder()
    for (i in 0..<stack.siZe(stack)) {
        ans.append(stack.data[i])
    }
    return ans.toString()
}