package src.main.kotlin.leetcode.contest


fun main() {
    println(isValid(readln()))
}
fun isValid(word: String): Boolean {
    val words=word.lowercase()
    if (words.length<3){
        return false
    }
    var vowel=false
    var consonent=false
    var isOutChar=false
    for (i in words.indices){
        if(!words[i].isLetterOrDigit()){
            isOutChar=true
        }else if(words[i]=='a'||words[i]=='e'||words[i]=='i'||words[i]=='o'||words[i]=='u') {
            vowel = true
        }else if(words[i]!='a'&&words[i]!='e'&&words[i]!='i'&&words[i]!='o'&&words[i]!='u' && !words[i].isDigit()){
            consonent=true
        }
    }
    return !isOutChar && vowel && consonent
}