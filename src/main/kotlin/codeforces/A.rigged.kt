package codeforces
import java.util.*

fun main() {
    val testcase=Scanner(System.`in`).nextInt();
    repeat(testcase){
        solve()
    }
}
fun solve(){
    val scan=Scanner(System.`in`)
    val n = scan.nextInt()
    val strength=IntArray(n)
    val endurance=IntArray(n)
    for (i in 0 until n){
        strength[i]=scan.nextInt()
        endurance[i]=scan.nextInt()
    }
    for (i in 1 until n){
        if(endurance[i]>=endurance[0] && strength[i]>=strength[0]){
            println(-1)
            return
        }
    }
    println(strength[0])
}