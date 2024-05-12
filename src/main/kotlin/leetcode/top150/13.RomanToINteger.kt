package src.main.kotlin.leetcode.top150

fun romanToInt(s: String): Int {
    val mp = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
    var ans=0
    for(i in s.indices){
        if(mp[s[i+1]]!=null && mp[s[i]]!=null &&(i+1<s.length) && (mp[s[i+1]]!! > mp[s[i]]!!)){
            mp[s[i]]?.let {
                ans-=it
            }
        }else{
            mp[s[i]]?.let {
                ans+=it
            }
        }
    }
    return ans
}

fun main() {

}