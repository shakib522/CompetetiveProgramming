package src.main.kotlin.leetcode


fun main() {
   println(isAnagram(readln(), readln()))
}
fun isAnagram(s: String, t: String): Boolean {
    val s1=s.toCharArray()
    val t1=t.toCharArray()
    s1.sort()
    t1.sort()
    return s1.contentEquals(t1)
}