import java.util.*

fun main() {
    val scanner=Scanner(System.`in`)
    val n=scanner.nextInt()
    val numArray=IntArray(n)
    for (i in 0..<n){
        numArray[i]=scanner.nextInt()
    }
   increasingTriplet(numArray)
}

fun increasingTriplet(nums: IntArray): Boolean {
    var target=Int.MAX_VALUE
    var min=Int.MAX_VALUE
    for (n in nums){
        if(n>target) return true
        if(n>min) target=n
        if(n<min) min=n
    }
    return false
}
