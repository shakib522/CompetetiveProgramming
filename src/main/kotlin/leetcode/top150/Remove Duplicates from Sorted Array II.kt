package src.main.kotlin.leetcode.top150

fun main(){
    val f= arrayOf(1,4,7,9)
    f.forEach {
        print("$it ")
    }
}

fun removeDuplicates(nums: IntArray): Int {
    if (nums.size<=2){
        return nums.size
    }
    var slow=2
    for (fast in 2..< nums.size){
        if (nums[slow-2]!=nums[fast]){
            nums[slow++]=nums[fast]
        }
    }
    return slow
}