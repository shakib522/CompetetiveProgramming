package src.main.kotlin.leetcode.q75

fun main() {

}

fun pathSum(root: TreeNode?, targetSum: Int): Int {
    if (root==null) return 0
    val pathsFromRoot = getSumCount(root,targetSum,0L)
    val pathsFromLeft = pathSum(root.left,targetSum)
    val pathsFromRight = pathSum(root.right,targetSum)
    return pathsFromRoot+pathsFromRight+pathsFromLeft
}

fun getSumCount(
    root : TreeNode?,
    targetSum: Int,
    sum:Long
):Int{
    if (root==null) return 0
    val curSum=sum+root.`val`
    var count=0

    if (targetSum.toLong() ==curSum) count++
    count+= getSumCount(root.left,targetSum,curSum)
    count+= getSumCount(root.right,targetSum,curSum)
    return count
}