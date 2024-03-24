import java.util.*

fun main() {
    val scanner=Scanner(System.`in`)
    val n=scanner.nextInt()
    scanner.nextLine()
    val numArray=IntArray(n)
    val string= scanner.nextLine()
    val ban=Array(n){" "}
    for (i in 0..<n){
        ban[i]=scanner.nextLine()
    }
    //println(mostCommonWord(string,ban))
}

//fun mostCommonWord(paragraph: String, banned: Array<String>): String {
//
//}
