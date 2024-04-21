package src.main.kotlin.leetcode.contest.weekly388.weekly394

fun main() {
    println(numberOfSpecialChars(readln()))
}

fun numberOfSpecialChars(word: String): Int {
    val array=IntArray(27)
    for (i in word.indices){
        if (word[i].code>=97){
            array[word[i].code-97]=1
        }
    }
    for (i in word.indices){
        if (word[i].code in 65..96){
            if(array[word[i].code-65]>0){
                array[word[i].code-65]++
            }
        }
    }
    var ans=0
    for (i in array){
       if (i>1){
           ans++
       }
    }
    return ans
}