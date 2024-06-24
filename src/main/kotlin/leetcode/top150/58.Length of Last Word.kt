package src.main.kotlin.leetcode.top150

fun main() {

}

fun lengthOfLastWord(s: String): Int {
    var ans=0
    var cnt=0
    for (i in s.indices){
        if (s[i].isLetter()){
            cnt++
        }else if (s[i].isWhitespace()){
            if (cnt!=0){
                ans=cnt
            }
            cnt=0
        }
    }
    if (cnt!=0){
        return cnt
    }
    return ans
}